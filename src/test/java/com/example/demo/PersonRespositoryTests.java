package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.domain.Person;

@DataJpaTest
public class PersonRespositoryTests {

	@Autowired
	PersonRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	public void insertSomeData() {
		Person person = new Person();
		person.setName("Nacho");
		person.setNickName("Natxeros");
		person.setCreatedOn(new Date(1000));
		entityManager.persistAndFlush(person);
	}
	
	@Test
	public void findByName() {
		assertEquals("Natxeros", repo.findByName("Nacho").get(0).getNickName());
	}
	
	@Test
	public void findByCreationDate() {
		assertEquals("Nacho", repo.findByCreatedOn(new Date(1000)).get(0).getName());
	}
}
