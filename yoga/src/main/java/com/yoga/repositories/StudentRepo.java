package com.yoga.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yoga.models.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	 Optional<Student> findByStudentEmail(String studentEmail);
	 Optional<Student> findByStudentName(String studentName);
	 
}
