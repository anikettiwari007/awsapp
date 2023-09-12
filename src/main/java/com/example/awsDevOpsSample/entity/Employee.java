package com.example.awsDevOpsSample.entity;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String firstName;
	private String lastName;
	private String address;
	private String profession;
	private Instant dateOfBirth;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(UUID id, String firstName, String lastName, String address, String profession,
			Instant dateOfBirth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.profession = profession;
		this.dateOfBirth = dateOfBirth;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Instant getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Instant dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", profession=" + profession + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
