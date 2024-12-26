package com.example.demo.Controller;

import com.example.demo.Domain.Report;
import com.example.demo.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/{id}")
    public Optional<Report> getReportById(@PathVariable Long id) {
        return reportService.getReportById(id);
    }

    @PostMapping
    public Report createReport(@RequestBody Report report) {
        return reportService.saveReport(report);
    }

    @PutMapping("/{id}")
    public Report updateReport(@PathVariable Long id, @RequestBody Report reportDetails) {
        Optional<Report> existingReport = reportService.getReportById(id);
        if (existingReport.isPresent()) {
            Report report = existingReport.get();
            report.setProduct(reportDetails.getProduct());
            report.setRisk(reportDetails.getRisk());
            report.setTypeOfRisk(reportDetails.getTypeOfRisk());
            report.setDescription(reportDetails.getDescription());
            return reportService.saveReport(report);
        }
        return null;
    }


}
