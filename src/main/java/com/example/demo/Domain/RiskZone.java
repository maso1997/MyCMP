package com.example.demo.Domain;

import com.example.demo.Domain.Analysis;
import com.example.demo.Domain.RiskEvaluation;
import com.example.demo.modal.Enum.MitigationFactorEnum;

import javax.persistence.*;
import java.util.List;

@Entity
public class RiskZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private MitigationFactorEnum mitigationFactor;

    @OneToMany(mappedBy = "riskZone", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Analysis> analyses;

    @ManyToOne
    @JoinColumn(name = "risk_evaluation_id", nullable = false)
    private RiskEvaluation riskEvaluation;

    public RiskZone() {
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

    public MitigationFactorEnum getMitigationFactor() {
        return mitigationFactor;
    }

    public void setMitigationFactor(MitigationFactorEnum mitigationFactor) {
        this.mitigationFactor = mitigationFactor;
    }

    public List<Analysis> getAnalyses() {
        return analyses;
    }

    public void setAnalyses(List<Analysis> analyses) {
        this.analyses = analyses;
    }

    public RiskEvaluation getRiskEvaluation() {
        return riskEvaluation;
    }

    public void setRiskEvaluation(RiskEvaluation riskEvaluation) {
        this.riskEvaluation = riskEvaluation;
    }
}