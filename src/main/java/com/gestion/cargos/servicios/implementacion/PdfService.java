package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.modelo.Planta;
import com.gestion.cargos.repositorio.PlantaRepositorio;
import com.gestion.cargos.servicios.interfaz.PlantaServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.List;

@Service
public class PdfService {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String  PDF_RESOURCES = "/pdf-resources/";

    private SpringTemplateEngine springTemplateEngine;

    @Autowired
    private PlantaRepositorio plantaServicio;

    @Autowired
    public PdfService(SpringTemplateEngine springTemplateEngine, PlantaRepositorio plantaServicio) {
        this.springTemplateEngine = springTemplateEngine;
        this.plantaServicio = plantaServicio;
    }

    public File generatePlantaPdf(Specification<Planta> specification) throws Exception{
        Context context = getContextPlantaListPdf(specification);
        String html = loadAndFillTemplate(context);
        String xhtml = convertToXhtml(html);
        return renderPlantaListPdf(xhtml);
    }

    private String convertToXhtml(String html) throws UnsupportedEncodingException {
        Tidy tidy = new Tidy();
        tidy.setXHTML(true);
        tidy.setIndentContent(true);
        tidy.setPrintBodyOnly(true);
        tidy.setInputEncoding("UTF-8");
        tidy.setOutputEncoding("UTF-8");
        tidy.setSmartIndent(true);
        tidy.setShowWarnings(false);
        tidy.setQuiet(true);
        tidy.setTidyMark(false);

        Document htmlDOM = tidy.parseDOM(new ByteArrayInputStream(html.getBytes()), null);
        OutputStream out = new ByteArrayOutputStream();
        tidy.pprint(htmlDOM, out);
        return  out.toString();
    }

    private File renderPlantaListPdf(String html) throws Exception {
        File file = File.createTempFile("plantas", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer(20f *  4f /3f, 20);
        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
        file.deleteOnExit();
        return file;
    }

    private Context getContextPlantaListPdf(Specification<Planta> specification){
        List<Planta> plantaList = this.plantaServicio.findAll(specification);

        logger.info("Cantidad Elemento de Planta " + plantaList.size());

        Context context = new Context();
        context.setVariable("plantas", plantaList);
        return context;
    }

    private String loadAndFillTemplate(Context context){
        return springTemplateEngine.process("plantasPDF", context);
    }
}
