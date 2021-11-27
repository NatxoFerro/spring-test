package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Person;

@SpringBootTest
@Transactional
public class PersonDAOTests {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private PersonDAO repository;
	
	@BeforeEach
	public void insertSampleData() {
		Person newPerson = new Person();
		newPerson.setName("Oicangi");
		newPerson.setCreatedOn(new Date(10000));
		entityManager.persist(newPerson);
	}
	
	@Test
	public void getPersonByName() {
		assertEquals("Oicangi", repository.getPersonByName("Oicangi").getName());
	}
	
	@Test
	public void getPersonByCreationDate() {
		assertEquals("Oicangi", repository.getPersonByCreationDate(new Date(5000)).get(0).getName());
	}
}
