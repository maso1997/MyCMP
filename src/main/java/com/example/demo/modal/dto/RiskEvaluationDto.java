package com.example.demo.modal.dto;

import java.util.List;

public class RiskEvaluationDto {
    private Long id ;
    private String riskName;
    private  String riskOwner;
    private  String productContext;
    private List<RiskZoneDto>riskZones;
    private String intrinsicRisk;
    private  String residualRisk;
    private  Boolean volcker;
    private  Boolean emir;
    private  Boolean fatca;
    private  Boolean flux ;
    private  Boolean codes ;
    private  String securityRisk ;
    private  Boolean mysnrmap;
    private  String reputationRisk ;
    private  ProductDto productDto;

    public Boolean getCodes() {
        return codes;
    }

    public void setCodes(Boolean codes) {
        this.codes = codes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getRiskOwner() {
        return riskOwner;
    }

    public void setRiskOwner(String riskOwner) {
        this.riskOwner = riskOwner;
    }

    public String getProductContext() {
        return productContext;
    }

    public void setProductContext(String productContext) {
        this.productContext = productContext;
    }

    public List<RiskZoneDto> getRiskZones() {
        return riskZones;
    }

    public void setRiskZones(List<RiskZoneDto> riskZones) {
        this.riskZones = riskZones;
    }

    public String getIntrinsicRisk() {
        return intrinsicRisk;
    }

    public void setIntrinsicRisk(String intrinsicRisk) {
        this.intrinsicRisk = intrinsicRisk;
    }

    public String getResidualRisk() {
        return residualRisk;
    }

    public void setResidualRisk(String residualRisk) {
        this.residualRisk = residualRisk;
    }

    public Boolean getVolcker() {
        return volcker;
    }

    public void setVolcker(Boolean volcker) {
        this.volcker = volcker;
    }

    public Boolean getEmir() {
        return emir;
    }

    public void setEmir(Boolean emir) {
        this.emir = emir;
    }

    public Boolean getFatca() {
        return fatca;
    }

    public void setFatca(Boolean fatca) {
        this.fatca = fatca;
    }

    public Boolean getFlux() {
        return flux;
    }

    public void setFlux(Boolean flux) {
        this.flux = flux;
    }

    public String getSecurityRisk() {
        return securityRisk;
    }

    public void setSecurityRisk(String securityRisk) {
        this.securityRisk = securityRisk;
    }

    public Boolean getMysnrmap() {
        return mysnrmap;
    }

    public void setMysnrmap(Boolean mysnrmap) {
        this.mysnrmap = mysnrmap;
    }

    public String getReputationRisk() {
        return reputationRisk;
    }

    public void setReputationRisk(String reputationRisk) {
        this.reputationRisk = reputationRisk;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }
}
