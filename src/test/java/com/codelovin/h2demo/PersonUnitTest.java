package com.codelovin.h2demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonUnitTest {

	@Mock
	private PersonRepository repo;

	@InjectMocks
	private PersonService service;

	@Test
	void savedPersonHasFirstName() {
		Person person = new Person("Chima", "Okeri", "Nairobi");
		when(repo.save(person)).thenReturn(person);
		Person savedPerson = service.savePerson(person);
		assertThat(savedPerson.getFirstName()).isNotNull();
	}

}
