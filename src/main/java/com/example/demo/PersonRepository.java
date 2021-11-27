package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	
	List<Person> findByName(String name);
	List<Person> findByCreatedOn(Date timestamp);
}
