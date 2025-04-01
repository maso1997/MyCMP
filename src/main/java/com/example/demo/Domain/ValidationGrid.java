package com.example.demo.Domain;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "ValidationGrids")
public class ValidationGrid {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator= "validation_grid_seq")
    @SequenceGenerator (name = "validation_grid_seq", sequenceName = "validation_grid_sequence", allocationSize = 1)
    private Long grid_id;
    private Date creation_date;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Produiict product;
    @ManyToOne
    @JoinColumn(name = "coordinator_id", referencedColumnName = "user_id")
    private User coordinator;

    public Long getGrid_id() {
        return grid_id;
    }

    public void setGrid_id(Long grid_id) {
        this.grid_id = grid_id;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Produiict getProduct() {
        return product;
    }

    public void setProduct(Produiict product) {
        this.product = product;
    }

    public User getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(User coordinator) {
        this.coordinator = coordinator;
    }
}