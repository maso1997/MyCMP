package com.example.demo.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

public class Analysis {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String answer;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "risk_zone_id")
    private RiskZone riskZone;

    public Analysis() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public RiskZone getRiskZone() {
        return riskZone;
    }

    public void setRiskZone(RiskZone riskZone) {
        this.riskZone = riskZone;
    }
}
