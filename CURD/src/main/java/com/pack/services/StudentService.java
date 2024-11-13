package com.pack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pack.dao.StudentRepository;
import com.pack.model.Student;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository; 
	
	public void saveAllStudentData(Student student1) {
		studentRepository.save(student1);
	}
	
	public List<Student> getAllStudentsData() {
		return studentRepository.findAll();
	}
	
	public Optional<Student> getStudent(int id) {
		return studentRepository.findById(id);
	}
	
	public void deleteStudent(int id) {
		 studentRepository.deleteById(id);
	}
}
