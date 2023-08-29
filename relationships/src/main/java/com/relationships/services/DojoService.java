package com.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.relationships.models.Dojo;
import com.relationships.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	public Dojo createDojo(Dojo e) {
		return dojoRepository.save(e);
	}
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	public Dojo updateDojo(Long id, String name) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			Dojo dojo = optionalDojo.get();
			dojo.setName(name);
			return dojoRepository.save(dojo);
		}
		else {
			return null;
		}
	}
	public Dojo updateDojo(Dojo dojo) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(dojo.getId());
	    if (optionalDojo.isPresent()) {
	        return dojoRepository.save(dojo);
	    } else {
	        return null;
	    }
	}
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
}
