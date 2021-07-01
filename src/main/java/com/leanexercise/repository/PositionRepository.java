package com.leanexercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leanexercise.model.Position;

public interface PositionRepository extends JpaRepository <Position, Long> {

	List<Position> findById(int position_id);
}
