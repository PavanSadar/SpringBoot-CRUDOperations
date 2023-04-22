package com.service;

import java.util.List;

import com.entity.Student;

public interface StudentService {

	String insertStudent(Student student);

	List<Student> getAllStudent();

	String deleteStudent(int id);

	String updateStudent(Student student, int sid);

}
