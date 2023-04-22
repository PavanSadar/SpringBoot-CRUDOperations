package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/save")
	private String insertStudent(@RequestBody Student student) {
		return service.insertStudent(student);
	}
	
	@GetMapping("/findAll")
	private List<Student> getAllStudent() {
		return service.getAllStudent();
	}
	
	@PutMapping("/update")
	private String updateStudent(@RequestBody Student student,
								@RequestParam (name = "sid") int sid) {
		return service.updateStudent(student,sid);
	}
	
	@DeleteMapping("/delete/{id}")
	private String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}

}
