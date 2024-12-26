package com.example.demo.Repository;

import com.example.demo.Domain.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskRepository extends JpaRepository<Risk , Integer> {
}
