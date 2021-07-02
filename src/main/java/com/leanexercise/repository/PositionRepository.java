package com.leanexercise.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leanexercise.model.Position;

public interface PositionRepository extends JpaRepository <Position, Long> {

	Optional<Position> findById(int position_id);
	Optional<Position> findByName(String name);
	
}
