package com.example.demo.Domain;
import javax.persistence.*;

@Entity
@Table(name = "Risks")
public class Risk {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "risk_seq")
    @SequenceGenerator(name = "risk_seq", sequenceName = "risk_sequence", allocationSize = 1)
    private Long risk_id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Produiict product;

    private String description;
    private int probability;
    private int impact;

    @ManyToOne
    @JoinColumn(name = "validation_grid_id", referencedColumnName = "grid_id")
    private ValidationGrid validationGrid;

    public Long getRisk_id() {
        return risk_id;
    }

    public void setRisk_id(Long risk_id) {
        this.risk_id = risk_id;
    }

    public Produiict getProduct() {
        return product;
    }

    public void setProduct(Produiict product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public int getImpact() {
        return impact;
    }

    public void setImpact(int impact) {
        this.impact = impact;
    }

    public ValidationGrid getValidationGrid() {
        return validationGrid;
    }

    public void setValidationGrid(ValidationGrid validationGrid) {
        this.validationGrid = validationGrid;
    }
}
