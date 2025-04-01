package com.example.demo.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

public class MitigationFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id ;
    @Column(columnDefinition = "TEXT")
    private String description ;
    @ManyToOne
    @JoinColumn(name = "risk_zone_id")
    @JsonBackReference
    private RiskZone riskZone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RiskZone getRiskZone() {
        return riskZone;
    }

    public void setRiskZone(RiskZone riskZone) {
        this.riskZone = riskZone;
    }
}
