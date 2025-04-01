package com.example.demo.mapper;

import com.example.demo.Domain.RiskEvaluation;
import com.example.demo.modal.dto.RiskEvaluationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RiskEvaluationMapper {

    @Mapping(target = "riskZones", source = "riskZones")
    @Mapping(target = "residualRisk", source = "residualRiskLevel")
    @Mapping(target = "intrinsicRisk", source = "intrinsicRiskLevel")
    @Mapping(target = "productDto", source = "product")
    @Mapping(target = "productDto.coordinateurCNP", source = "product.coordinateurCNP.user_id")
    RiskEvaluationDto toDto(RiskEvaluation riskEvaluation);

    @Mapping(target = "riskZones", source = "riskZones")
    @Mapping(target = "residualRiskLevel", source = "residualRisk")
    @Mapping(target = "intrinsicRiskLevel", source = "intrinsicRisk")
    @Mapping(target = "product", source = "productDto")
    @Mapping(target = "product.coordinateurCNP.user_id", source = "productDto.coordinateurCNP")
    RiskEvaluation toEntity(RiskEvaluationDto riskEvaluationDTO);
}