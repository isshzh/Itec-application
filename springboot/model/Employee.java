package net.javaguides.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "position")
	private String position;
	
	
	public Employee(String firstName, String lastName, String emailAddress) { //
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;


	}
	public long getId() { //method
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailId(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}