package com.projeto.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.projeto.data.vo.v2.PersonVOV2;
import com.projeto.model.Person;

@Service
public class PersonMapper {

	public PersonVOV2 convertEntityToVo(Person person) {
		PersonVOV2 vov2 = new PersonVOV2();
		vov2.setId(person.getId());
		vov2.setNome(person.getNome());
		vov2.setSobrenome(person.getSobrenome());
		vov2.setEndereco(person.getEndereco());
		vov2.setGenero(person.getGenero());
		vov2.setAniversario(new Date());
		
		return vov2;
	}
	
	
	public Person convertVoToEntity(PersonVOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setNome(person.getNome());
		entity.setSobrenome(person.getSobrenome());
		entity.setEndereco(person.getEndereco());
		entity.setGenero(person.getGenero());
//		entity.setAniversario(new Date());
		
		return entity;
	}
}
