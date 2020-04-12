package com.codelovin.h2demo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

	// @Autowired
	// private PersonRepository personRepository;

	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public String getTheFullName(Long personId) throws NoSuchElementException {
		Optional<Person> person = personRepository.findById(personId);
		Person p = null;
		if (person.isPresent()) {
			p = person.get();
		} else {
			throw new NoSuchElementException("No value present");
		}
		StringBuilder fullName = new StringBuilder();
		fullName.append(p.getFirstName()).append(" ").append(p.getLastName());
		return fullName.toString();
	}
	
	public List<Person> retrievePersons() {
		List<Person> persons = personRepository.findAll();
		return persons;
	}

	public Person getPerson(Long pesonId) {
		Optional<Person> optEmp = personRepository.findById(pesonId);
		return optEmp.get();
	}
	
	public Person getPersonByFirstName(String firstName) {
		Person obj = personRepository.findByFirstName(firstName);
		return obj;
	}

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public void updatePerson(Person person) {
		personRepository.save(person);
	}

	public void deletePerson(Long personId) {
		personRepository.deleteById(personId);
	}
}
