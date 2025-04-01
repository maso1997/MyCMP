package com.example.demo.mapper;

import com.example.demo.Domain.MitigationFactor;
import com.example.demo.modal.dto.MitigationFactorDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MitigationFactorMapper {
    MitigationFactorDto toDto ( MitigationFactor mitigationFactor);
    MitigationFactor toEntity (MitigationFactorDto mitigationFactorDto);
}
