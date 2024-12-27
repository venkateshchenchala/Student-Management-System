package com.jsp.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.demo.entity.Student;
import com.jsp.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository sr;

	public List<Student> getAllStudents() {
		return sr.findAll();
	}

	public Optional<Student> getStudentById(int id) {
		return sr.findById(id);
	}

	public Student saveStudent(Student student) {
		return sr.save(student);
	}

	public void deleteStudent(int id) {
		sr.deleteById(id);
	}

	
}
