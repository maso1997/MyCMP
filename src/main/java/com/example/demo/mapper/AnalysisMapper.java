package com.example.demo.mapper;

import com.example.demo.Domain.Analysis;
import com.example.demo.modal.dto.AnalysisDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AnalysisMapper {
    AnalysisDto toDto (Analysis analysis);
    Analysis toEntity (AnalysisDto analysisDto);
}
