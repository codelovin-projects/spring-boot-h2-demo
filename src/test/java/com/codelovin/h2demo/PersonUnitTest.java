package com.codelovin.h2demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;

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

	@Test
	void retrievedPersonHasFullName() {
		Person person = new Person("Sunil", "Sharma", "Mumbai");
		Optional<Person> optPerson = Optional.of(person);
		when(repo.findById(10L)).thenReturn(optPerson);
		
		String fullName = service.getTheFullName(10L);
		assertEquals("Sunil Sharma",fullName);
	}
	
	@Test
	void testNoSuchElementException() {		
		Exception exception = assertThrows(
				NoSuchElementException.class, 
				() -> service.getTheFullName(9L));
		
		assertThat(exception).isNotNull();
		assertTrue(exception.getMessage().contains("No value present"));
	}
}
