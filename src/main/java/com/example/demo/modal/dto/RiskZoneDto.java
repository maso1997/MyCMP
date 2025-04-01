package com.example.demo.modal.dto;

import java.util.List;

public class RiskZoneDto {
    private Long id ;
    private  String name ;
    private  String description;
    private  String mitigationFactor;
    private List<AnalysisDto> analyses;

    public RiskZoneDto(Long id, String name, String description, String mitigationFactor, List<AnalysisDto> analyses) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.mitigationFactor = mitigationFactor;
        this.analyses = analyses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMitigationFactor() {
        return mitigationFactor;
    }

    public void setMitigationFactor(String mitigationFactor) {
        this.mitigationFactor = mitigationFactor;
    }

    public List<AnalysisDto> getAnalyses() {
        return analyses;
    }

    public void setAnalyses(List<AnalysisDto> analyses) {
        this.analyses = analyses;
    }
}
