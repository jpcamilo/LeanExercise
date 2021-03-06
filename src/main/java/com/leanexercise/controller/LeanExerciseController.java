package com.leanexercise.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leanexercise.model.Candidate;
import com.leanexercise.model.Employee;
import com.leanexercise.model.Position;
import com.leanexercise.repository.LeanExerciseRepository;
import com.leanexercise.repository.PositionRepository;
import com.leanexercise.repository.CandidateRepository;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class LeanExerciseController {


	@Autowired
	LeanExerciseRepository LeanExerciseRepository;
	@Autowired
	PositionRepository PositionRepository;
	@Autowired
	CandidateRepository CandidateRepository;
	

	@GetMapping("/LeanExercise")
	public ResponseEntity<List<Employee>> getAllEmployee(@RequestParam(required = false) String nombre, String cargo) {
		try {
			List<Employee> Employee = new ArrayList<Employee>();

			if (nombre != null) 
				LeanExerciseRepository.findByPersonName(nombre).forEach(Employee::add);
			else if (cargo != null) 
				LeanExerciseRepository.findByPositionName(cargo, Sort.by("Salary").descending()).forEach(Employee::add);
			else
				LeanExerciseRepository.findAll().forEach(Employee::add);
				
			if (Employee.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(Employee, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/LeanExercise/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
		Optional<Employee> EmployeeData = LeanExerciseRepository.findById(id);

		if (EmployeeData.isPresent()) {
			return new ResponseEntity<>(EmployeeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//////servicio exclusivo para crear el empleado
	@PostMapping("/LeanExercise")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee Employee) {
		try {
	
			Employee _Employee = LeanExerciseRepository
						.save(new Employee(Employee.getPerson().getId(), Employee.getPosition().getId(), Employee.getSalary()));

			////fragmento para mostrar el empleado creado
			 Optional<Position> position = PositionRepository.findByName(Employee.getPosition().getName());
			 Position _Position = position.get();			
			 Optional<Candidate> candidate = CandidateRepository.findById(Employee.getPerson().getId());
			 Candidate _Candidate = candidate.get();			
			 _Employee.setPerson(_Candidate);
			 _Employee.setPosition(_Position);
			//////////////////////////////////////
			return new ResponseEntity<>(_Employee, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Error al crear empleado: "+e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//////servicio exclusivo para crear cargos ded trabajo
	@PostMapping("/CrearCargos")
	public ResponseEntity<Position> createPosition(@RequestBody Position Position) {
		try {

			 Optional<Position> position = PositionRepository.findByName(Position.getName());
			 Position _Position;
			 if (position.isEmpty()) {
				 _Position = PositionRepository.save(new Position(Position.getName()));
				 return new ResponseEntity<>(_Position, HttpStatus.CREATED);
			 }else {
				 _Position = position.get();
				 System.out.println("El Cargo ya se encuentra creado: "+_Position.toString());
				 return new ResponseEntity<>(_Position, HttpStatus.CONFLICT);
			 }

		} catch (Exception e) {
			System.out.println("Error al crear cargo: "+e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

////servicio exclusivo para crear el candidato///////////
	@PostMapping("/CrearCandidato")
	public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate Person) {
		try {

			Candidate  _Person =CandidateRepository
					.save(new Candidate(Person.getName(), Person.getLasname(),
							Person.getAddress(), Person.getCellphone(), Person.getCityname()));

			return new ResponseEntity<>(_Person, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Error al crear el candidato: "+e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/LeanExercise/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee Employee) {
		Optional<Employee> EmployeeData = LeanExerciseRepository.findById(id);

		if (EmployeeData.isPresent()) {
			
			Employee _Employee = EmployeeData.get();
			_Employee.setPerson(Employee.getPerson());
			_Employee.setPosition(Employee.getPosition());
			_Employee.setSalary(Employee.getSalary());
			return new ResponseEntity<>(LeanExerciseRepository.save(_Employee), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/LeanExercise/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			LeanExerciseRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/LeanExercise")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			LeanExerciseRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/LeanExercise/Cargos")
	public ResponseEntity<List<Position>> findByPosition() {
		try {
			List<Position> Position = PositionRepository.findAll();
			
			List<Employee> Employee = new ArrayList<Employee>();
			
			  for (Position position2 : Position) {
				  System.out.println("Position name: "+position2.getName());	  
				  LeanExerciseRepository.findByPositionName(position2.getName(),Sort.by("Salary").descending()).forEach(Employee::add);;

				  for (Employee employee2 : Employee) {
					employee2.setPosition(null);
				  }
				  
				  position2.setEmployee(Employee);
				  Employee =new ArrayList<Employee>();
			  }
			 
			
			if (Position.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Position, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
}
