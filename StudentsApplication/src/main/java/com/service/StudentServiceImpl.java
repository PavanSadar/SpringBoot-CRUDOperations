package com.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public String insertStudent(Student student) {
		Student existStudent = null;
		String result;
		existStudent = repository.save(student);
		if (existStudent != null) {
			result = "Save Successfully";
		} else {
			result = "Insertion failed";
		}
		return result;
	}

	@Override
	public List<Student> getAllStudent() {
		return repository.findAll();
	}

	@Override
	public String deleteStudent(int id) {
		String result;
		repository.deleteById(id);
		Optional<Student> existStudent = repository.findById(id);
		if(existStudent.isPresent()) {
			result = "Record is not deleted";
		}else {
			result = "Record is deleted";
		}
		return result;
	}

	@Override
	public String updateStudent(Student student, int sid) {
		String result;
		Optional<Student> existStudent = repository.findById(sid);
		Student updateStudent = null;
		if(existStudent.isPresent()) {
			updateStudent = existStudent.get();
			updateStudent.setName(student.getName());
			updateStudent.setAddress(student.getAddress());
			updateStudent.setAge(student.getAge());
			updateStudent.setStream(student.getStream());
			repository.save(updateStudent);
			result = "Update Successfully";
		}else {
			result = "Record not found";
		}
		return result;
	}

}
