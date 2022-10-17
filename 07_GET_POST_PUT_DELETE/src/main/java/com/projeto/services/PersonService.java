package com.projeto.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.projeto.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
			
	
	public List<Person> findAll() {
		logger.info("Finding all person!");
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}
	
	public Person findById(String id) {
		
		logger.info("Finding one person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setNome("Marcos");
		person.setSobrenome("Paulo");
		person.setEndereco("São Paulo");
		person.setGenero("Homem");
		return person;
	}
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating one person!");
		
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting one person!");
	}
	
	private Person mockPerson(int i) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setNome("Person name" + i);
		person.setSobrenome("Last Name" + i);
		person.setEndereco("Some adress in Brazil" + i);
		person.setGenero("Male");
		return person;
	}
}
