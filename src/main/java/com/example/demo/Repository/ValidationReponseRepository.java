package com.example.demo.Repository;

import com.example.demo.Domain.ValidationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationReponseRepository extends JpaRepository<ValidationResponse, Long> {
}
