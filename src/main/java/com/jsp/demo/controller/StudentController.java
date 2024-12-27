package com.jsp.demo.controller;

import java.util.List;

import org.antlr.v4.runtime.atn.SemanticContext.OR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsp.demo.entity.Student;
import com.jsp.demo.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService ss;

	@GetMapping("/students/new")
	public String showCreateForm(Model model) {
		model.addAttribute("student", new Student());
		return "student-form";
	}

	  @PostMapping("/students")
	    public String saveStudent(@ModelAttribute("student") Student student) {
	        ss.saveStudent(student);
	        return "success";
	    }
	  @GetMapping("/students")
	    public String getAllStudents(Model model) {
	        List<Student> students = ss.getAllStudents();
	        model.addAttribute("students", students);
	        return "students";
	    }

	    @GetMapping("/students/{id}")
	    public String getStudentById(@PathVariable int id, Model model) {
	        Student student = ss.getStudentById(id).get();
	        model.addAttribute("student", student);
	        return "student";
	    }
	    
	    @GetMapping("students/delete/{id}")
	    public String deleteStudentById(@PathVariable int id) {
	        ss.deleteStudent(id);
	        return "deletestudent";
	    }


}
