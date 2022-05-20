package com.example.codingbatstructure.repository;

import com.example.codingbatstructure.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer,Integer> {
}
