package com.example.demo.Domain;

import com.example.demo.modal.Enum.RiskLevel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.*;


    @Entity
    public class RiskEvaluation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String riskName;

        private String riskOwner;

        @Column(columnDefinition = "TEXT")
        private String productContext;

        @JsonIgnore
        @OneToMany(mappedBy = "riskEvaluation", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<RiskZone> riskZones;

        @Enumerated(EnumType.STRING)
        private RiskLevel intrinsicRiskLevel;

        @Enumerated(EnumType.STRING)
        private RiskLevel residualRiskLevel;

        private Boolean volcker;
        private Boolean emir;
        private Boolean fatca;
        private Boolean flux;
        private Boolean codes;
        private String securityRisk;
        private Boolean mysnrmap;
        private String reputationRisk;

        @ManyToOne
        @JoinColumn(name = "product_id")
        private Product product;

        public RiskEvaluation() {
        }

        public Boolean getFlux() {
            return flux;
        }

        public void setFlux(Boolean flux) {
            this.flux = flux;
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

        public List<RiskZone> getRiskZones() {
            return riskZones;
        }

        public void setRiskZones(List<RiskZone> riskZones) {
            this.riskZones = riskZones;
        }

        public RiskLevel getIntrinsicRiskLevel() {
            return intrinsicRiskLevel;
        }

        public void setIntrinsicRiskLevel(RiskLevel intrinsicRiskLevel) {
            this.intrinsicRiskLevel = intrinsicRiskLevel;
        }

        public RiskLevel getResidualRiskLevel() {
            return residualRiskLevel;
        }

        public void setResidualRiskLevel(RiskLevel residualRiskLevel) {
            this.residualRiskLevel = residualRiskLevel;
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

        public Boolean getCodes() {
            return codes;
        }

        public void setCodes(Boolean codes) {
            this.codes = codes;
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

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
    }


