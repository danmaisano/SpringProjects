package com.yoga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoga.models.YogaClass;
import com.yoga.repositories.YogaClassRepo;

@Service
public class YogaClassService {
	
	@Autowired
	private YogaClassRepo yogaClassRepo;
	
	public YogaClass addClass(YogaClass newYogaClass) {
        return yogaClassRepo.save(newYogaClass);
    }
	
	public List<YogaClass> getAllClasses(){
        return yogaClassRepo.findAll();
    }
	
	public YogaClass getClassById(Long id) {
	    Optional<YogaClass> optionalYogaClass = yogaClassRepo.findById(id);
	    if (optionalYogaClass.isPresent()) {
	        return optionalYogaClass.get();
	    } else {
	        return null;
	    }
	}
	
	
	public YogaClass updateClass(YogaClass updatedYogaClass) {
	    Optional<YogaClass> optionalYogaClass = yogaClassRepo.findById(updatedYogaClass.getId());
	    if (optionalYogaClass.isPresent()) {
	        YogaClass classToBeUpdated = optionalYogaClass.get();
	        classToBeUpdated.setClassName(updatedYogaClass.getClassName());
	        classToBeUpdated.setDayOfWeek(updatedYogaClass.getDayOfWeek());
	        classToBeUpdated.setPrice(updatedYogaClass.getPrice());
	        classToBeUpdated.setTime(updatedYogaClass.getTime());
	        classToBeUpdated.setDescription(updatedYogaClass.getDescription());
	        classToBeUpdated.setInstructor(updatedYogaClass.getInstructor());
	        classToBeUpdated.setStudents(updatedYogaClass.getStudents());

	        return yogaClassRepo.save(classToBeUpdated);
	    }
	    return null;
	}


	
	public void deleteClass(Long id) {
		yogaClassRepo.deleteById(id);
	}
	

}
