package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Person;

@Component
public class CustomRunner implements CommandLineRunner {

	@Autowired
	PersonDAO dao;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Executing CustomRunner...");
		Person person = new Person();
		person.setName("Pepe");
		dao.save(person);
		person.setName("Modified");
	}
}
