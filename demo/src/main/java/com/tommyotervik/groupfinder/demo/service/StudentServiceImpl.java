package com.tommyotervik.groupfinder.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tommyotervik.groupfinder.demo.dao.StudentDAO;
import com.tommyotervik.groupfinder.demo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	@Override
	@Transactional
	public Student findById(int id) {
		return studentDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Student student) {
		studentDAO.save(student);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		studentDAO.deleteById(id);

	}

}
