package com.leanexercise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Candidate")
public class Candidate {
	
	@SequenceGenerator(
		    name="CandidateSeq",
		    sequenceName = "CANDIDATE_SEQ",
		    initialValue = 1, 
		    allocationSize = 1
	)		
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CandidateSeq")
	private int id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "lasname")
	private String lasname;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "cellphone")
	private String cellphone;
	
	@Column(name = "cityname")
	private String cityname;

	public Candidate() {

	}

	public Candidate(String name, String lasname, String address, String cellphone, String cityname) {
		super();
		this.name = name;
		this.lasname = lasname;
		this.address = address;
		this.cellphone = cellphone;
		this.cityname = cityname;
	}

	public Candidate(int id) {
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

	public String getLasname() {
		return lasname;
	}

	public void setLasname(String lasname) {
		this.lasname = lasname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}



}
