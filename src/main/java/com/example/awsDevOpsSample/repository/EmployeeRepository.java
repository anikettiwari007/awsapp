package com.example.awsDevOpsSample.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.awsDevOpsSample.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID>{

}
