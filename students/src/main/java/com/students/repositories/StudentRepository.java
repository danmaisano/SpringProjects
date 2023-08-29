package com.students.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.students.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findAll();
	Optional<Student> findById(Long id);

}