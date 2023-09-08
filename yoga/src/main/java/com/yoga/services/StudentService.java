package com.yoga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoga.models.Student;
import com.yoga.repositories.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	public Student addStudent(Student newStudent) {
        return studentRepo.save(newStudent);
    }
	
	public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }
	
	public Student getStudentById(Long id) {
	    Optional<Student> optionalStudent = studentRepo.findById(id);
	    if (optionalStudent.isPresent()) {
	        return optionalStudent.get();
	    } else {
	        return null;
	    }
	}
	
	public Student getStudentByName(String studentName) {
	    Optional<Student> optionalStudent = studentRepo.findByStudentName(studentName);
	    if (optionalStudent.isPresent()) {
	        return optionalStudent.get();
	    } else {
	        return null;
	    }
	}

	public Student updateStudent(Student updatedStudent) {
		Optional<Student> optionalStudent = studentRepo.findById(updatedStudent.getId());
		if (optionalStudent.isPresent()) {
			Student studentToBeUpdated = optionalStudent.get();
			return studentRepo.save(studentToBeUpdated);
		}
		return null;
	}

	
	public void deleteStudent(Long id) {
		studentRepo.deleteById(id);
	}
	

}
