package com.projeto.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.exception.ResourceNotFoundExcepetion;
import com.projeto.model.Person;
import com.projeto.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());

	@Autowired
	PersonRepository repository;

	public List<Person> findAll() {
		logger.info("Finding all person!");

		return repository.findAll();
	}

	public Person findById(Long id) {

		logger.info("Finding one person!");

		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcepetion("No records found by ID!"));
	}

	public Person create(Person person) {
		logger.info("Creating one person!");

		return repository.save(person);
	}

	public Person update(Person person) {
		logger.info("Updating one person!");

		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundExcepetion("No records found by ID!"));

		entity.setNome(person.getNome());
		entity.setSobrenome(person.getSobrenome());
		person.setEndereco(person.getEndereco());
		entity.setGenero(person.getGenero());

		return repository.save(person);
	}

	public void delete(Long id) {
		logger.info("Deleting one person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcepetion("No records found by ID!"));

		repository.delete(entity);
	}

//	
//	private Person mockPerson(int i) {
//		
//		Person person = new Person();
//		person.setId(counter.incrementAndGet());
//		person.setNome("Person name" + i);
//		person.setSobrenome("Last Name" + i);
//		person.setEndereco("Some adress in Brazil" + i);
//		person.setGenero("Male");
//		return person;
//	}
}
