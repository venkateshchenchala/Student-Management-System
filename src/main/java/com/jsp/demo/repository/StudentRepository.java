package com.jsp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.demo.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
