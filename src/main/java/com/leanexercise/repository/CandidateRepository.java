package com.leanexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leanexercise.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long>{

}
