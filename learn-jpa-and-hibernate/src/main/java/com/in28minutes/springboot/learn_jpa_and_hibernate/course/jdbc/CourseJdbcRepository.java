package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc.course.Course;

@Repository
public class CourseJdbcRepository {

	// to fire query using jdbc
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	// to excute a querry
	// to enter hardocoded values
//	private static String INSERT_QUERRY = 
//				"""
//				insert into course(id,name,author)
//				values
//				(1, 'Learn AWS', 'in28minutes')
//				""";
	
	// to enter values using class course
	private static String INSERT_QUERRY = 
			"""
			insert into course(id,name,author)
			values
			(?, ?, ?)
			""";
	
	private static String DELETE_QUERRY = 
			"""
			delete from  course where id = ?
			""";
	
	private static String SELECT_QUERRY = 
			"""
			select * from course where id = ?
			""";
	
//	public void insert() {
//		springJdbcTemplate.update(INSERT_QUERRY);
//	}
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERRY,course.getId(),course.getName(),course.getAuthor());
	}
	public void deleteById(long id) {
	springJdbcTemplate.update(DELETE_QUERRY, id);
}
	
	public Course findById(long id) {
	return springJdbcTemplate.queryForObject(SELECT_QUERRY, new BeanPropertyRowMapper<>(Course.class),id);
	
	// set the result to a bean using row mappers(new BeanPropertyRowMapper<>(Course.class))
	// id 
}
	
}
