package com.leanexercise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;






@Entity
@Table(name = "Position")
public class Position {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;
	
    //@OneToMany(mappedBy = "position", fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
    //private Set<Employee> employees;

	public Position() {
		
	}

	public Position(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	
	
}
