package com.example.codingbatstructure.repository;

import com.example.codingbatstructure.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Integer>{

}
