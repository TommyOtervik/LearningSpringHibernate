package com.tommyotervik.groupfinder.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tommyotervik.groupfinder.demo.entity.Student;
import com.tommyotervik.groupfinder.demo.exception.StudentNotFoundException;
import com.tommyotervik.groupfinder.demo.service.StudentService;



@RestController
@RequestMapping("/api")
public class StudentController {
	
	// Studentservice dependancy injection
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> findAll() {
		return studentService.findAll();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		Student student = studentService.findById(studentId);
		
		if (student == null) {
			throw new StudentNotFoundException("Student not found.");
		}
		
		return student;
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		
		// Just in case they pass in ID
		// this is to force a save of a new item, instead of update
		
		student.setId(0);
		
		studentService.save(student);
		
		return student;
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		
		studentService.save(student);
		
		return student;
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		
		Student student = studentService.findById(studentId);
		
		if (student == null) {
			throw new StudentNotFoundException("Student not found.");
		}
		
		studentService.deleteById(studentId);
		
		return "Deleted employee id: " + studentId;
	}
	

}
