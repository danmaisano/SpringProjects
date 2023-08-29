package com.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.relationships.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();

}