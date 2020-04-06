package com.codelovin.h2demo;

import java.util.List;

import javax.validation.Valid;

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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
	public ResponseEntity<Person> getPerson(@PathVariable(name = "firstName") String firstName) {
		Person person = personService.getPersonByFirstName(firstName);
		if (person == null) {
			throw new PersonNotFoundException("FirstName: " + firstName);
		}
		person.add(linkTo(methodOn(PersonRestController.class).getPersons()).withRel("all-persons"));
		return new ResponseEntity<>(person, HttpStatus.OK);
	}

	@PostMapping("/api/persons")
	public Person savePerson(@Valid @RequestBody Person person) {
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
