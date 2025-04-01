package com.example.demo.modal.dto;

import java.time.LocalDate;

public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private LocalDate dateLancement;
    private String motif;
    private String statut;
    private Long codeQalification;
    private Long porteursMetierIds;
    private Long porteursProjetIds;
    private Long coordinateurCNP;
    private Long sponsorsMIds;
    private String nomProduit;


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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Long getCodeQalification() {
        return codeQalification;
    }

    public void setCodeQalification(Long codeQalification) {
        this.codeQalification = codeQalification;
    }

    public Long getPorteursMetierIds() {
        return porteursMetierIds;
    }

    public void setPorteursMetierIds(Long porteursMetierIds) {
        this.porteursMetierIds = porteursMetierIds;
    }

    public Long getPorteursProjetIds() {
        return porteursProjetIds;
    }

    public void setPorteursProjetIds(Long porteursProjetIds) {
        this.porteursProjetIds = porteursProjetIds;
    }

    public Long getCoordinateurCNP() {
        return coordinateurCNP;
    }

    public void setCoordinateurCNP(Long coordinateurCNP) {
        this.coordinateurCNP = coordinateurCNP;
    }

    public Long getSponsorsMIds() {
        return sponsorsMIds;
    }

    public void setSponsorsMIds(Long sponsorsMIds) {
        this.sponsorsMIds = sponsorsMIds;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }
}
