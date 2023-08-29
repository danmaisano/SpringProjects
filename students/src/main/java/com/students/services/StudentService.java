package com.students.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.models.Dorm;
import com.students.models.Student;
import com.students.repositories.StudentRepository;
import com.students.repositories.DormRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    
    @Autowired
	private DormRepository dormRepository;
    
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public List<Student> allStudents(){
        return studentRepository.findAll();
    }
    
    public Student createStudent(Student e) {
        return studentRepository.save(e);
    }
    
    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student updateStudent(Long id, String name, Dorm dorm) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(name);
            student.setDorm(dorm);
            return studentRepository.save(student);
        }
        throw new RuntimeException("Student not found");
    }

    public Student updateStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if (optionalStudent.isPresent()) {
            return studentRepository.save(student);
        }
        throw new RuntimeException("Student not found");
    }
    
    public void deleteStudent(Long id) {
        if(studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return;
        }
        throw new RuntimeException("Student not found");
    }
    
    public void assignStudentToDorm(Long studentId, Long dormId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Dorm dorm = dormRepository.findById(dormId).orElse(null);

        if (student != null && dorm != null) {
            student.setDorm(dorm);
            studentRepository.save(student);
        }
    }
}
