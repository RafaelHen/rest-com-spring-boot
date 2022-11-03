package com.projeto.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.data.vo.v1.PersonVO;
import com.projeto.exception.ResourceNotFoundExcepetion;
import com.projeto.mapper.DozerMapper;
import com.projeto.model.Person;
import com.projeto.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());

	@Autowired
	PersonRepository repository;

	public List<PersonVO> findAll() {
		logger.info("Finding all PersonVO!");

		return DozerMapper.parseListObject(repository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {

		logger.info("Finding one PersonVO!");

		var Entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcepetion("No records found by ID!"));
		return DozerMapper.parseObject(Entity, PersonVO.class);
	}

	public PersonVO create(PersonVO person) {
		logger.info("Creating one person!");
		var entity = DozerMapper.parseObject(person, Person.class);
		var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public PersonVO update(PersonVO PersonVO) {
		logger.info("Updating one PersonVO!");

		var entity = repository.findById(PersonVO.getId())
				.orElseThrow(() -> new ResourceNotFoundExcepetion("No records found by ID!"));

		entity.setNome(PersonVO.getNome());
		entity.setSobrenome(PersonVO.getSobrenome());
		PersonVO.setEndereco(PersonVO.getEndereco());
		entity.setGenero(PersonVO.getGenero());

		var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public void delete(Long id) {
		logger.info("Deleting one PersonVO!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcepetion("No records found by ID!"));

		repository.delete(entity);
	}

//	
//	private PersonVO mockPerson(int i) {
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
