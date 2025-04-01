package com.example.demo.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_sequence", allocationSize = 1)
    private Long id;

    private String name;

    private String description;

    private LocalDate dateLancement;

    private String motif;

    @NotNull()
    @ManyToOne
    private User porteurProjet;

    @NotNull()
    @ManyToOne
    private User porteurMetier;

    @ManyToOne
    private User coordinateurCNP;

    @ManyToOne
    private User sponsorM;

    private String statut;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RiskEvaluation> riskEvaluations;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
//    private List<Commentaire> commentaires;


    public Product() {
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

    public LocalDate getDateLancement() {
        return dateLancement;
    }

    public void setDateLancement(LocalDate dateLancement) {
        this.dateLancement = dateLancement;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public User getPorteurProjet() {
        return porteurProjet;
    }

    public void setPorteurProjet(User porteurProjet) {
        this.porteurProjet = porteurProjet;
    }

    public User getPorteurMetier() {
        return porteurMetier;
    }

    public void setPorteurMetier(User porteurMetier) {
        this.porteurMetier = porteurMetier;
    }

    public User getCoordinateurCNP() {
        return coordinateurCNP;
    }

    public void setCoordinateurCNP(User coordinateurCNP) {
        this.coordinateurCNP = coordinateurCNP;
    }

    public User getSponsorM() {
        return sponsorM;
    }

    public void setSponsorM(User sponsorM) {
        this.sponsorM = sponsorM;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public List<RiskEvaluation> getRiskEvaluations() {
        return riskEvaluations;
    }

    public void setRiskEvaluations(List<RiskEvaluation> riskEvaluations) {
        this.riskEvaluations = riskEvaluations;
    }
}