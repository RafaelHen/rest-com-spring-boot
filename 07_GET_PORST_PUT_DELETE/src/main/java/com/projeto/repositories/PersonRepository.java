package com.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
