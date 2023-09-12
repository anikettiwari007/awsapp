package com.example.awsDevOpsSample.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.awsDevOpsSample.entity.Employee;
import com.example.awsDevOpsSample.repository.EmployeeRepository;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.ok(employeeRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable UUID id){
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<Employee>(employeeRepository.save(emp), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable UUID id, @RequestBody Employee emp){
		return employeeRepository.findById(id).map(employee -> {
			
			employee.setAddress(emp.getAddress());
			employee.setDateOfBirth(emp.getDateOfBirth());
			employee.setLastName(emp.getLastName());
			employee.setFirstName(emp.getFirstName());
			
			return new ResponseEntity<Employee>(employeeRepository.save(employee), HttpStatus.OK);
		})
		.orElse(new ResponseEntity<Employee>(employeeRepository.save(emp), HttpStatus.OK));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable UUID id){
		employeeRepository.deleteById(id);
		return new ResponseEntity<String>("Successfully Deleted.", HttpStatus.OK);
	}
}
