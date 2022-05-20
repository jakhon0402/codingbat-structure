package com.example.codingbatstructure.repository;

import com.example.codingbatstructure.entity.Answer;
import com.example.codingbatstructure.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
