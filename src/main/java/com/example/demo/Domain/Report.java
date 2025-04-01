package com.example.demo.Domain;

import javax.persistence.*;

@Entity
@Table(name = "Reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_seq")
    @SequenceGenerator(name = "report_seq", sequenceName = "report_sequence", allocationSize = 1)
    private Long report_id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Produiict product;

    @ManyToOne
    @JoinColumn(name = "risk_id", referencedColumnName = "risk_id")
    private Risk risk;

    private String typeOfRisk;
    private String description;

    public Long getReport_id() {
        return report_id;
    }

    public void setReport_id(Long report_id) {
        this.report_id = report_id;
    }

    public Produiict getProduct() {
        return product;
    }

    public void setProduct(Produiict product) {
        this.product = product;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }

    public String getTypeOfRisk() {
        return typeOfRisk;
    }

    public void setTypeOfRisk(String typeOfRisk) {
        this.typeOfRisk = typeOfRisk;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
