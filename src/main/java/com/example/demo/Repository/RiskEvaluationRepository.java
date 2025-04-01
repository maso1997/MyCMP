package com.example.demo.Repository;

import com.example.demo.Domain.RiskEvaluation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskEvaluationRepository extends JpaRepository<RiskEvaluation, Long> {
     Page<RiskEvaluation> findByProductId(Long productId , Pageable pageable);

}
