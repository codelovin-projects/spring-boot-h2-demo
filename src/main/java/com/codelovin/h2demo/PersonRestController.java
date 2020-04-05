package com.codelovin.h2demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRestController {

	@Autowired
	private PersonService personService;

	@GetMapping("/api/persons")
	public ResponseEntity<List<Person>> getPersons() {
		List<Person> persons = personService.retrievePersons();
		return new ResponseEntity<>(persons, HttpStatus.OK);
	}
	
	@GetMapping("/api/persons/{firstName}")
	public Person getPerson(@PathVariable(name = "firstName") String firstName) {
		return personService.getPersonByFirstName(firstName);
	}

	@PostMapping("/api/persons")
	public Person savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}

	@DeleteMapping("/api/perons/{personId}")
	public void deleteEmployee(@PathVariable(name = "personId") Long personId) {
		personService.deletePerson(personId);
	}

	@PutMapping("/api/persons/{personId}")
	public void updatePerson(@RequestBody Person person, @PathVariable(name = "personId") Long personId) {
		Person b = personService.getPerson(personId);
		if (b != null) {
			personService.updatePerson(person);
		}
	}
}
