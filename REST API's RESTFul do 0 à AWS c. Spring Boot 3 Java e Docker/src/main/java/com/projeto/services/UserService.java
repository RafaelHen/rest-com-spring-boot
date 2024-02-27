package com.projeto.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
import com.projeto.model.User;
import com.projeto.repositories.PersonRepository;
import com.projeto.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{

	private Logger logger = Logger.getLogger(PersonService.class.getName());

	@Autowired
	UserRepository repository;

	public UserService(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Finding one user by name "+username+"!");
		User user = repository.findByUsername(username);
		if (user != null) {
			return user;
		}else {
			throw new UsernameNotFoundException("User "+ username +" not found!");
		}
	}

}
