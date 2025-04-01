package com.example.demo.Service;

import com.example.demo.Domain.Product;
import com.example.demo.Domain.RiskEvaluation;
import com.example.demo.Domain.RiskZone;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.RiskEvaluationRepository;
import com.example.demo.mapper.RiskEvaluationMapper;
import com.example.demo.modal.dto.RiskEvaluationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class RiskEvaluationService {

    @Autowired
    private RiskEvaluationRepository riskEvaluationRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RiskEvaluationMapper riskEvaluationMapper;

    public Page<RiskEvaluationDto> getAllRiskEvaluations(Pageable pageable) {
        return riskEvaluationRepository.findAll(pageable)
                .map(riskEvaluationMapper::toDto);
    }

    public Page<RiskEvaluationDto> getAllRiskEvaluationsByProductId(Long productId, Pageable pageable) {
        return riskEvaluationRepository.findByProductId(productId, pageable)
                .map(riskEvaluationMapper::toDto);
    }

    public RiskEvaluationDto getRiskEvaluationById(Long id) {
        return riskEvaluationRepository.findById(id)
                .map(riskEvaluationMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("RiskEvaluation not found with ID: " + id));
    }

    @Transactional
    public void createOrUpdateRiskEvaluations(Product product) {
        List<RiskEvaluation> riskEvaluations = riskEvaluationRepository.findAll();

        riskEvaluations.forEach(riskEvaluation -> {
            riskEvaluation.setProduct(product);

            riskEvaluation.getRiskZones().forEach(rz -> {
                rz.setRiskEvaluation(riskEvaluation);
                if (rz.getAnalyses() != null) {
                    rz.getAnalyses().forEach(a -> a.setRiskZone(rz));
                }
            });
        });

        // Save all entities (assuming cascading is properly configured)
        List<RiskEvaluation>sendEntities = riskEvaluationRepository.saveAll(riskEvaluations);
    }

    @Transactional
    public RiskEvaluationDto updateRiskEvaluation(Long id, RiskEvaluationDto riskEvaluationDTO) {
        Optional<RiskEvaluation> existingEvaluation = riskEvaluationRepository.findById(id);

        if (!existingEvaluation.isPresent()) {
            throw new EntityNotFoundException("RiskEvaluation with ID " + id + " not found.");
        }

        RiskEvaluation riskEvaluation = riskEvaluationMapper.toEntity(riskEvaluationDTO);
        riskEvaluation.setId(id);

        for (RiskZone rz : riskEvaluation.getRiskZones()) {
            if (rz.getAnalyses() != null) {
                rz.getAnalyses().forEach(a -> a.setRiskZone(rz));
            }
            rz.setRiskEvaluation(riskEvaluation);
        }

        RiskEvaluation updatedEntity = riskEvaluationRepository.save(riskEvaluation);
        return riskEvaluationMapper.toDto(updatedEntity);
    }

    public void deleteRiskEvaluation(Long id) {
        if (!riskEvaluationRepository.existsById(id)) {
            throw new EntityNotFoundException("RiskEvaluation not found with ID: " + id);
        }
        riskEvaluationRepository.deleteById(id);
    }
}
