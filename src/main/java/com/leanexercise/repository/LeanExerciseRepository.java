package com.leanexercise.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.leanexercise.model.Employee;

public interface LeanExerciseRepository extends JpaRepository<Employee, Long> { 

	//List<Employee> findByPositionContaining(String cargo);
	List<Employee> findByPersonContaining(String nombre);
	List<Employee> findByPositionName(String name, Sort sort);
	List<Employee> findByPersonName(String name);
}
