package com.leanexercise.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "Position")
public class Position {
	
	@SequenceGenerator(
		    name="PositionSeq",
		    sequenceName = "POSITION_SEQ",
		    initialValue = 1, 
		    allocationSize = 1
	)		
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PositionSeq")
	private int id;

	@Column(name = "name")
	private String name;
	
	@ElementCollection
	private List<Employee> employee;
	
    //@OneToMany(mappedBy = "position", fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
    //private Set<Employee> employees;

	public Position() {
		
	}



	public Position(String name) {
		super();
		this.name = name;
	}

	public Position(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public List<Employee> getEmployee() {
		return employee;
	}



	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}




	
}
