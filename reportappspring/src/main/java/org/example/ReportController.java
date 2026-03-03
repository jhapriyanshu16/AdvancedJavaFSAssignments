package org.example;

import org.example.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ReportController {

    @Autowired
    @Qualifier("pdfReportService")
    private ReportService pdfService;

    @Autowired
    @Qualifier("excelReportService")
    private ReportService excelService;

    public void generate(int choice) {

        switch (choice) {
            case 1:
                pdfService.generateReport();
                break;

            case 2:
                excelService.generateReport();
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
}