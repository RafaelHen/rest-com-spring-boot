package com.projeto.unittest.mockito.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.projeto.data.vo.v1.PersonVO;
import com.projeto.model.Person;
import com.projeto.repositories.PersonRepository;
import com.projeto.services.PersonService;
import com.projeto.unittests.mapper.dozer.MockPerson;

@TestInstance(Lifecycle.PER_CLASS) //ESTA CLASSE SERÁ INSTANCIADA, A PARTIR DESSA ANOTAÇÀO É DEFINIDO O CICLO DE VIDA DELA
@ExtendWith(MockitoExtension.class)

class PersonServiceTest {

	MockPerson input;
	
	@InjectMocks
	private PersonService personService;
	
	@Mock
	PersonRepository personRepository;
	
	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockPerson();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() throws Exception {
		Person person = input.mockEntity(1);
		person.setId(1L);
		when(personRepository.findById(1L)).thenReturn(Optional.of(person));
		PersonVO result = personService.findById(1L);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		System.out.println(result.toString());
		assertTrue(result.toString().contains("links: [</person/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", result.getEndereco());
		assertEquals("First Name Test1", result.getNome());
		assertEquals("Last Name Test1", result.getSobrenome());
		assertEquals("Female", result.getGenero());
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateV2() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
