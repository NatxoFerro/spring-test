package com.example.demo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Person;

@Repository
@Transactional
public class PersonDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Person person) {
		entityManager.persist(person);
	}
	
	public Person getPersonByName(String name) {
		String hql = "select p from Person p where p.name = :name";
		return entityManager.createQuery(hql, Person.class).setParameter("name", name).getSingleResult();
	}
	
	public List<Person> getPersonByCreationDate(Date timestamp) {
		String hql = "select p from Person p where p.createdOn > ?1";
		return entityManager.createQuery(hql, Person.class).setParameter(1, timestamp).getResultList();
	}
}
