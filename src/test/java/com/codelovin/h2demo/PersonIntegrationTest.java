package com.codelovin.h2demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private PersonRepository repo;

	@Test
	void testAllLayers() throws Exception {
		Person person = new Person("Elon", "Musk", "Saint Paul");
		mockMvc.perform(post("/api/billionaires").contentType("application/json")
				.content(objectMapper.writeValueAsString(person)))
				.andExpect(status().isOk());

		Person elon = repo.findByFirstName("Elon");
		assertThat(elon.getLastName()).isEqualTo("Musk");
	}
}
