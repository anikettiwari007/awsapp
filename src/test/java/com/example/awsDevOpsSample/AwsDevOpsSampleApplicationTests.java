package com.example.awsDevOpsSample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class AwsDevOpsSampleApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void EmployeeController_getAllEmployee_ReturnAllEmployees() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/employee"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
	}
}
