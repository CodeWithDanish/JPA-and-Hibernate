package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


// JPA to talk to DB we create an Entity Manager
@Repository
@Transactional
public class CourseJpaRepository {
	
//	@Autowired
	
	// more specific 
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
	 entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}

	public void deleteById(long id) {
		 Course course = entityManager.find(Course.class, id);
		 entityManager.remove(course);
	}
		
}
