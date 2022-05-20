package com.example.codingbatstructure.repository;

import com.example.codingbatstructure.entity.Answer;
import com.example.codingbatstructure.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepo extends JpaRepository<Example,Integer> {
}
