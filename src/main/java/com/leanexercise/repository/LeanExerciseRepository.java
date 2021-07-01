package com.leanexercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leanexercise.model.Employee;
import com.leanexercise.model.Position;

public interface LeanExerciseRepository extends JpaRepository<Employee, Long> { 

	//List<Employee> findByPositionContaining(String cargo);
	List<Employee> findByPersonContaining(String nombre);
	List<Employee> findByPositionName(String name);
}
