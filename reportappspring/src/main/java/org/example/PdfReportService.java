package org.example;

import org.springframework.stereotype.Component;

@Component("pdfReportService")
public class PdfReportService implements ReportService {

    @Override
    public void generateReport() {
        System.out.println("Generating PDF Report...");
    }
}