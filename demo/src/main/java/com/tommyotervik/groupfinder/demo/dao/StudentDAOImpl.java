package com.tommyotervik.groupfinder.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tommyotervik.groupfinder.demo.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Student> findAll() {
		
		// get current hibernate session
		
		Session session = entityManager.unwrap(Session.class);
		
		// create a query
		
		
		// OBS from Student, ikke Students, selv om Students er navnet på tabellen i databasen
		
		Query<Student> query = session.createQuery("from Student", Student.class);
		
		
		// execute query and get result list
		
		List<Student> students = query.getResultList();
		
		// return the results
		
		return students;
	}

	@Override
	public Student findById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Student student = session.get(Student.class, id);
		
		return student;
	}

	@Override
	public void save(Student student) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(student);
		
	}

	@Override
	public void deleteById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("delete from Students where id=:studentId");
		
		query.setParameter("studentId", id);
		
		query.executeUpdate();
		

	}

}
