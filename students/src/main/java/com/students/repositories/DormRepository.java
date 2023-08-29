package com.students.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.students.models.Dorm;

public interface DormRepository extends CrudRepository<Dorm, Long>{
	List<Dorm> findAll();
	Optional<Dorm> findById(Long id);

}