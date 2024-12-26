package com.example.demo.Repository;

import com.example.demo.Domain.ValidationGrid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationGridRepository  extends JpaRepository <ValidationGrid, Long> {
}
