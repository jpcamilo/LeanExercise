package com.leanexercise.model;

import javax.persistence.*;


@Entity
@Table(name = "Employee")
public class Employee {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;

		@Column(name = "person")
		private String person;
		
	    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    //@JoinColumn(name = "position_id", nullable = false)
		@ManyToOne
	    private Position position;

		@Column(name = "salary")
		private int salary;

		public Employee() {

		}
		
		public Employee(String person, int position_id, int salary) {
			this.person = person;
			this.salary = salary;
			this.position = new Position(position_id,"");
		}

		


		public void setId(long id) {
			this.id = id;
		}

		public void setPerson(String person) {
			this.person = person;
		}

		public void setPosition(Position position) {
			this.position = position;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public long getId() {
			return id;
		}

		public String getPerson() {
			return person;
		}

		public Position getPosition() {
			return position;
		}

		public int getSalary() {
			return salary;
		}

		//corregir
		@Override
		public String toString() {
			return "Employee [id=" + id + ", person=" + person + ", position=" + position + ", salary=" + salary + "]";
		}	
	
		
}
