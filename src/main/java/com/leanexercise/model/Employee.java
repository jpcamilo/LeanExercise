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

		@Column(name = "position")
		private String position;

		@Column(name = "salary")
		private int salary;

		public Employee() {

		}
		
		public Employee(String person, String position, int salary) {
			this.person = person;
			this.position = position;
			this.salary = salary;
		}

		public long getId() {
			return id;
		}

		
		public String getPerson() {
			return person;
		}

		public void setPerson(String person) {
			this.person = person;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", person=" + person + ", position=" + position + ", salary=" + salary + "]";
		}	
	
		
}
