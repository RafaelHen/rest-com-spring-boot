package com.projeto.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.projeto.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
			
	
	public Person findById(String id) {
		
		logger.info("Buscando uma pessoa!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setNome("Marcos");
		person.setSobrenome("Paulo");
		person.setEndereco("São Paulo");
		person.setGenero("Homem");
		return person;
	}
}
