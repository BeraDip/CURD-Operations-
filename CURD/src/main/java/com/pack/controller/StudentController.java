package com.pack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dao.StudentRepository;
import com.pack.model.Student;
import com.pack.services.StudentService;



@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService; 
	
	
	 //All Student Save
	@PostMapping("/SaveAllStudent")
	public String save(@RequestBody Student student1) {
		studentService.saveAllStudentData(student1);
		return "Success";
	}

	
	 //All Student Get
	@GetMapping("/GetAllStudent")
	public List<Student> getAllStudent(){
		return this.studentService.getAllStudentsData();
	}
	
	 //Single Student Get
	@GetMapping("/GetSingleStudent/{id}")
	public Optional<Student> getStudent(@PathVariable("id") int id) {
		return this.studentService.getStudent(id);
	}
	
	//Single Student delete
	@RequestMapping(value="Delete/Student/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
		return "delete success";
	}
	
	@Autowired
	StudentRepository studentRepository; 
	

    // Update a Student
    @PutMapping("UpdateStudent/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student studentDetails) {
        Optional<Student> optionalStudent = studentService.getStudent(id);
        if (!optionalStudent.isPresent()) {
            return "Not valid id";
        }

        Student existingStudent = optionalStudent.get();
        existingStudent.setName(studentDetails.getName());
        existingStudent.setDepartment(studentDetails.getDepartment());
        existingStudent.setState(studentDetails.getState());
        existingStudent.setCity(studentDetails.getCity());

        Student updatedStudent = studentRepository.save(existingStudent);
        return "done";
    }
}

