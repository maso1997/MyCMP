package com.example.demo.Repository;

import com.example.demo.Domain.ValidationQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationQuestionRepository extends JpaRepository <ValidationQuestion , Long> {

}
