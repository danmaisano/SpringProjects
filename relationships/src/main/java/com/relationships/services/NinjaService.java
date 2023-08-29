package com.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.relationships.models.Ninja;
import com.relationships.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	public Ninja createNinja(Ninja e) {
		return ninjaRepository.save(e);
	}
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
	public Ninja updateNinja(Long id, String firstName, String lastName, Integer age) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			Ninja ninja = optionalNinja.get();
			ninja.setFirstName(firstName);
			ninja.setLastName(lastName);
			ninja.setAge(age);
			return ninjaRepository.save(ninja);
		}
		else {
			return null;
		}
	}
	public Ninja updateNinja(Ninja ninja) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(ninja.getId());
	    if (optionalNinja.isPresent()) {
	        return ninjaRepository.save(ninja);
	    } else {
	        return null;
	    }
	}
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
}
