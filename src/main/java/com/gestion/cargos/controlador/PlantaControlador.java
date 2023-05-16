package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.*;
import com.gestion.cargos.modelo.Planta;
import com.gestion.cargos.repositorio.PlantaRepositorio;
import com.gestion.cargos.servicios.implementacion.ExcelService;
import com.gestion.cargos.servicios.implementacion.PdfService;
import com.gestion.cargos.servicios.implementacion.PlantaServicioImpl;
import com.gestion.cargos.specifications.PlantaSpecification;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;
import com.gestion.cargos.validator.PlantaValidatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("planta")
public class PlantaControlador {

    private final PdfService pdfService;

    private final ExcelService excelService;
    Logger logger = LoggerFactory.getLogger(PlantaControlador.class);
    @Autowired
    private PlantaServicioImpl plantaServicio;

    @Autowired
    private PlantaRepositorio plantaRepositorio;

    @Autowired
    PlantaValidatorImpl plantaValidator;
    @Autowired
    public PlantaControlador(PdfService pdfService, ExcelService excelService) {
        this.pdfService = pdfService;
        this.excelService = excelService;
    }

    @Autowired
    //private PlantaSpecificationService.java plantaServiceCriteria;

    @GetMapping(value = "/libres/ocupado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PuntoDetailDTO>> findPuntosOcupadosLibres() {
        return ResponseEntity.ok(this.plantaServicio.findByPlantaOfPuntos());
        // new ResponseEntity<List<PuntoDetailDTO>>(this.joinPlantaService.findByPlantaDisponible() ,HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlantaDTO>> findAllPlanta() {
        return ResponseEntity.ok(this.plantaServicio.findAll());
    }

    @GetMapping(value = "/{plantaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlantaDTO> findByPlantaId(@PathVariable Long plantaId) {

        return ResponseEntity.ok(this.plantaServicio.findByPlantaId(plantaId));
    }

    @GetMapping(value = "/codigo/{cargo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlantaDTO>> findByPlantaCargo(@PathVariable Long cargo) {
        return ResponseEntity.ok(this.plantaServicio.findByPlantaByCargo(cargo));
    }


    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> savePlanta(@RequestBody PlantaRequest request) throws ApiUnprocessableEntity {
        this.plantaValidator.validator(request);
        this.plantaServicio.save(request);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/update/{plantaId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePlanta(@PathVariable Long plantaId, @RequestBody PlantaRequest request) throws ApiUnprocessableEntity {

        if (!this.plantaServicio.existByPlantaId(plantaId)) {
            return new ResponseEntity(new Mensaje("La Planta de Cargo no existe"), HttpStatus.NOT_FOUND);
        }
        this.plantaValidator.validator(request);
        logger.info("PLANTA " + request);
        this.plantaServicio.update(plantaId, request);

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Planta>> list(@RequestBody BusquedaDTO dto){
        //Specification<Planta> specification = PlantaSpecification.hasLastNameLike("ROMI");
        //Specification<Planta> specification = PlantaSpecification.hasTypeCargo("PROF. TITULAR -DEDICACION EXCLUSIVA");
        // Specification<Planta> specification = PlantaSpecification.hasSubject("Calculo Numerico");
        Specification<Planta> specification = PlantaSpecification.createSpecification(dto);
        List<Planta> plantas =  this.plantaRepositorio.findAll(specification); //this.plantaSpecificationService.findPlantaByNombreAgente();
        return ResponseEntity.ok(plantas);
    }

    @PostMapping("/pdf")
    public void downloadPdf(HttpServletResponse response, @RequestBody BusquedaDTO dto){
        Specification<Planta> specification = PlantaSpecification.createSpecification(dto);

        try {
            Path file = Paths.get(pdfService.generatePlantaPdf(specification).getAbsolutePath());
            if(Files.exists(file)){
                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition", "attachment; filename" + file.getFileName());
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
        }catch (Exception e){
             e.printStackTrace();
        }
    }

    @PostMapping("/export/excel")
    public void exportAllData(final HttpServletResponse response, @RequestBody BusquedaDTO dto) throws IOException{
        Specification<Planta> specification = PlantaSpecification.createSpecification(dto);

        excelService.exportAllData(response, specification);


    }

/*    @PostMapping("/list")
    public ResponseEntity<List<Planta>> list(@RequestBody BusquedaDTO busquedaDTO) {
        PlantaCriteria plantaCriteria = createCriteria(busquedaDTO);
        List<Planta> list = plantaServiceCriteria.findByCriteria(plantaCriteria);

        return new ResponseEntity<List<Planta>>(list, HttpStatus.OK);
    }

    private PlantaCriteria createCriteria(BusquedaDTO dto) {
        PlantaCriteria plantaCriteria = new PlantaCriteria();
        if (dto != null) {

            if (!StringUtils.isBlank(dto.getDocente())) {
                StringFilter filter = new StringFilter();
                filter.setContains(dto.getDocente());
                plantaCriteria.setDocente(filter);
            }
            if (!StringUtils.isBlank(dto.getMateria())) {
                StringFilter filter = new StringFilter();
                filter.setEquals(dto.getMateria());
                plantaCriteria.setMateria(filter);

            }
            if (!StringUtils.isBlank(dto.getTipocargo())) {
                StringFilter filter = new StringFilter();
                filter.setEquals(dto.getTipocargo());
                plantaCriteria.setTipocargo(filter);
            }

        }
        return plantaCriteria;
    }
*/
}
