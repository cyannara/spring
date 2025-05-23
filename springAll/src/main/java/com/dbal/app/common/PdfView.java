package com.dbal.app.common;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Component
public class PdfView extends AbstractView {
    @Autowired
    @Qualifier("dataSourceSpied")
    DataSource datasource;

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Connection conn = datasource.getConnection();
        String reportFile = (String) model.get("filename");
        InputStream jasperStream = getClass().getResourceAsStream(reportFile);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        //다운로드 
    }
}
