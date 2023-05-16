package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.modelo.Planta;
import com.gestion.cargos.repositorio.PlantaRepositorio;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    Logger looger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PlantaRepositorio plantaService;

    public void exportAllData(final HttpServletResponse response, Specification<Planta> specification) throws IOException{

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=planta-record.xls");
        final var outputStream = new BufferedOutputStream(response.getOutputStream());


        List<Planta> plantaList = this.plantaService.findAll(specification);

        looger.info("Cantidad de registros de PLANTA " + plantaList.size() );

        String columns[] = { "Cod Cargo", "Nombre", "Apellido", "Departamento","Materia", "Tipo Cargo"};
        Workbook workbook = new HSSFWorkbook();

        final var style = workbook.createCellStyle();
        final var font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
 //       ByteArrayOutputStream stream = new ByteArrayOutputStream();

        Sheet sheet = workbook.createSheet("Informe Planta");

        Row row = sheet.createRow(0);

        for (int i = 0; i < columns.length ; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(columns[i]);
        }


        int initRow = 1;

        for (Planta planta: plantaList
             ) {

            row = sheet.createRow(initRow);
            row.createCell(0).setCellValue(String.valueOf(planta.getCargoId().getIdCargo()));
            row.createCell(1).setCellValue(planta.getAgenteId().getNombre());
            row.createCell(2).setCellValue(planta.getAgenteId().getApellido());
            row.createCell(3).setCellValue(planta.getCargoId().getUnidadOrganizativaId().getNombre());
            row.createCell(4).setCellValue(planta.getSubunidadOrganizativaId().getNombre());
            row.createCell(5).setCellValue(planta.getCargoId().getPuntoId().getTipo_cargo().getCargo());

            initRow++;
        }

        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        //return new ByteArrayInputStream(stream.toByteArray());
    }

}
