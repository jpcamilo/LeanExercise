package com.leanexercise.model;

import javax.persistence.*;


/**
 * @author PedrazJ1
 *
 */
/**
 * @author PedrazJ1
 *
 */
/**
 * @author PedrazJ1
 *
 */
/**
 * @author PedrazJ1
 *
 */
@Entity
@Table(name = "Employee")
public class Employee {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;

		@OneToOne
		private Candidate person;
		
	    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    //@JoinColumn(name = "position_id", nullable = false)
		@ManyToOne
	    private Position position;

		@Column(name = "salary")
		private int salary;

		public Employee() {

		}
		
		public Employee(int person_id, int position_id, int salary) {
			this.person =  new Candidate(person_id,"","","","", "");
			this.salary = salary;
			this.position = new Position(position_id,"");
		}

		
		public Candidate getPerson() {
			return person;
		}

		public void setPerson(Candidate person) {
			this.person = person;
		}

		public Position getPosition() {
			return position;
		}

		public void setPosition(Position position) {
			this.position = position;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		//corregir
		@Override
		public String toString() {
			return "Employee [id=" + id + ", person=" + person + ", position=" + position + ", salary=" + salary + "]";
		}	
	
		
}
