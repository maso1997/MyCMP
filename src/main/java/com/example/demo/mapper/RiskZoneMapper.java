package com.example.demo.mapper;

import com.example.demo.Domain.RiskZone;
import com.example.demo.modal.dto.RiskZoneDto;
import org.mapstruct.Mapping;

public interface RiskZoneMapper {
    @Mapping(target = "analyses", source = "analyses")
    RiskZoneDto toDto(RiskZone riskZone);
    @Mapping(target = "analyses" ,source = "analyses")
    RiskZoneDto toEntity(RiskZoneDto riskZoneDto);
}