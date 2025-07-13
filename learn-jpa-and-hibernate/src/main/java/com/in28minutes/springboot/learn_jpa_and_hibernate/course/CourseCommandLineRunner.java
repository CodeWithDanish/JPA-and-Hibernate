package com.in28minutes.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc.course.Course;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;


@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;

	@Autowired
	private CourseSpringDataJpaRepository repository;
	@Override
	public void run(String... args) throws Exception {
		
		// to insert for JDBC
//		repository.insert();
		// to insert for JPA
//		repository.insert(new Course(1,"Learn JPA Now","in28miutes"));
//		repository.insert(new Course(2,"Learn Azure Now","in28miutes"));
//		repository.insert(new Course(3,"Learn DevOps Now !","in28miutes"));
		
//		 to insert for spring JPA
//		repository.insert(new Course(1,"Learn JPA Now","in28miutes"));
//		repository.insert(new Course(2,"Learn Azure Now","in28miutes"));
//		repository.insert(new Course(3,"Learn DevOps Now !","in28miutes"));
		
//		 to insert for SpringDataJpa
		repository.save(new Course(1,"Learn JPA Now","in28miutes"));
		repository.save(new Course(2,"Learn Azure Now","in28miutes"));
		repository.save(new Course(3,"Learn DevOps Now !","in28miutes"));
		
		// to insert for JDBC and JPA
//		repository.deleteById(2);

		// to insert for spring JPA
//		repository.deleteById(2);
//		repository.deleteById(3);
		
		//  to insert for SpringDataJpa
		repository.deleteById(2l);
		
//	System.out.println(repository.findById(1l));
		
		// to select for SpringDataJpa
//	System.out.println(repository.findAll());
//	System.out.println(repository.count());
	System.out.println(repository.findByAuthor("in28miutes"));
	System.out.println(repository.findByAuthor(""));
	System.out.println(repository.findByName("Learn JPA Now"));
	System.out.println(repository.findByName(""));
	
	
	
	}

}
