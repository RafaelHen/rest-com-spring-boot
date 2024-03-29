package com.projeto.unittests.mapper.dozer;

import java.util.ArrayList;
import java.util.List;

import com.projeto.data.vo.v1.PersonVO;
import com.projeto.model.Person;

public class MockPerson {
	// VERIFICA SE QUANDO CONVERTE UM VO PARA ENTIDADE OS DADOS CONTINUAM OS MESMOS 
	//Mock de entidade
    public Person mockEntity() {
        return mockEntity(0);
    }
    
    //Mock de VO
    public PersonVO mockVO() {
        return mockVO(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonVO> mockVOList() {
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setEndereco("Addres Test" + number);
        person.setNome("First Name Test" + number);
        person.setGenero(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setSobrenome("Last Name Test" + number);
        return person;
    }

    public PersonVO mockVO(Integer number) {
        PersonVO person = new PersonVO();
        person.setEndereco("Addres Test" + number);
        person.setNome("First Name Test" + number);
        person.setGenero(((number % 2)==0) ? "Male" : "Female");
        person.setKey(number.longValue());
        person.setSobrenome("Last Name Test" + number);
        return person;
    }

}
