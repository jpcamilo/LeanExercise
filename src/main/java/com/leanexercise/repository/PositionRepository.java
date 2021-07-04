package com.leanexercise.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.leanexercise.model.Position;



public interface PositionRepository extends JpaRepository <Position, Long> {

	Optional<Position> findById(int position_id);
	Optional<Position> findByName(String name);

//	@Query(value = "SELECT POSITION.ID, POSITION.NAME, EMPLOYEE.ID AS ID, EMPLOYEE.SALARY FROM POSITION, EMPLOYEE WHERE POSITION.ID=EMPLOYEE.POSITION_ID  ORDER BY EMPLOYEE.SALARY ;", nativeQuery=true)
//	List<Position> findAll();
	
}
