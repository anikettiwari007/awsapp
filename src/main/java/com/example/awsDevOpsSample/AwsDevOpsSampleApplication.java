package com.example.awsDevOpsSample;

import java.time.Instant;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.awsDevOpsSample.entity.Employee;
import com.example.awsDevOpsSample.repository.EmployeeRepository;

@SpringBootApplication
public class AwsDevOpsSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsDevOpsSampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner sampleData(EmployeeRepository empRepository) {
		return (args) -> {
			empRepository.save(new Employee(UUID.randomUUID(), "Rohit", "Sharma", "Mumbai", "Batsman", Instant.now()));
			empRepository.save(new Employee(UUID.randomUUID(), "Tilak", "Varma", "Andhra Pradesh", "AllRounder", Instant.now()));
			empRepository.save(new Employee(UUID.randomUUID(), "Virat", "Kohli", "Delhi", "Batsman", Instant.now()));
		};
	}
}
