package com.students.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.students.models.Dorm;
import com.students.repositories.DormRepository;

@Service
public class DormService {
	private final DormRepository dormRepository;
	
	public DormService(DormRepository dormRepository) {
		this.dormRepository = dormRepository;
	}
	
	public List<Dorm> allDorms(){
		return dormRepository.findAll();
	}
	public Dorm createDorm(Dorm e) {
		return dormRepository.save(e);
	}
	public Dorm findDorm(Long id) {
		Optional<Dorm> optionalDorm = dormRepository.findById(id);
		if(optionalDorm.isPresent()) {
			return optionalDorm.get();
		}
		else {
			return null;
		}
	}
	public Dorm updateDorm(Long id, String name) {
		Optional<Dorm> optionalDorm = dormRepository.findById(id);
		if(optionalDorm.isPresent()) {
			Dorm dorm = optionalDorm.get();
			dorm.setName(name);
			return dormRepository.save(dorm);
		}
		else {
			return null;
		}
	}
	public Dorm updateDorm(Dorm dorm) {
		Optional<Dorm> optionalDorm = dormRepository.findById(dorm.getId());
	    if (optionalDorm.isPresent()) {
	        return dormRepository.save(dorm);
	    } else {
	        return null;
	    }
	}
	public void deleteDorm(Long id) {
		dormRepository.deleteById(id);
	}
}
