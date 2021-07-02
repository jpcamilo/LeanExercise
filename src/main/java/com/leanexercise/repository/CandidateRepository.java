package com.leanexercise.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leanexercise.model.Candidate;
import com.leanexercise.model.Employee;

public interface CandidateRepository extends JpaRepository<Candidate, Long>{

	//List<Candidate> findById(int id);
	Optional<Candidate> findById(int id);
	
}
