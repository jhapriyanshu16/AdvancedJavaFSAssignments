package org.example;

import org.springframework.stereotype.Component;

@Component("excelReportService")
public class ExcelReportService implements ReportService {

    @Override
    public void generateReport() {
        System.out.println("Generating Excel Report...");
    }
}