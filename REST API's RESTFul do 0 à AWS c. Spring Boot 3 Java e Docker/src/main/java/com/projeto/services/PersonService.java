package com.projeto.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import com.projeto.controllers.PersonController;
import com.projeto.data.vo.v1.PersonVO;
import com.projeto.data.vo.v2.PersonVOV2;
import com.projeto.exception.ResourceNotFoundExcepetion;
import com.projeto.mapper.DozerMapper;
import com.projeto.mapper.custom.PersonMapper;
import com.projeto.model.Person;
import com.projeto.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());

	@Autowired
	PersonRepository repository;

	@Autowired
	PersonMapper personMapper;

	public List<PersonVO> findAll(){
		logger.info("Finding all PersonVO!");
		List<Person> person = repository.findAll();
		List<PersonVO> personVOs = new ArrayList<>();
		person.forEach(e -> personVOs.add(DozerMapper.parseObject(e, PersonVO.class)));

		personVOs
			.stream()
			.forEach(p -> {
				try {
					p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel());
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

		return personVOs;
	}

	public PersonVO findById(Long id) throws Exception {

		logger.info("Finding one PersonVO!");

		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcepetion("No records found by ID!"));
		PersonVO vo = DozerMapper.parseObject(entity, PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return vo;
	}

	public PersonVO create(PersonVO person) throws Exception {
		logger.info("Creating one person!");
		Person entity = DozerMapper.parseObject(person, Person.class);
		PersonVO vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public PersonVOV2 createV2(PersonVOV2 personVOV2) {
		logger.info("Creating one person!");
		Person entity = personMapper.convertVoToEntity(personVOV2);
		var vo =  personMapper.convertEntityToVo(repository.save(entity));
		return vo;
	}
	
	

	public PersonVO update(PersonVO PersonVO) throws Exception {
		logger.info("Updating one PersonVO!");

		Person entity = repository.findById(PersonVO.getKey())
				.orElseThrow(() -> new ResourceNotFoundExcepetion("No records found by ID!"));

		entity.setNome(PersonVO.getNome());
		entity.setSobrenome(PersonVO.getSobrenome());
		PersonVO.setEndereco(PersonVO.getEndereco());
		entity.setGenero(PersonVO.getGenero());

		PersonVO vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());

		return vo;
	}

	public void delete(Long id) {
		logger.info("Deleting one PersonVO!");

		Person entity = repository.findById(id)
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
