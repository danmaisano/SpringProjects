package com.dojoOverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.dojoOverflow.models.Question;
import com.dojoOverflow.models.Tag;
import com.dojoOverflow.repositories.TagRepo;

@Service
public class TagService {
	
	@Autowired
	private TagRepo tagRepo;
	
	@Autowired
	private QuestionService questionService;
	
	public Tag addTag(Tag newTag, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		return tagRepo.save(newTag);
	}
	
	public List<Tag> allTags(){
        return tagRepo.findAll();
    }
	
	public List<Tag> createTagsFromForm(String tagString) {
	    String[] tagNames = tagString.split(",");
	    List<Tag> tags = new ArrayList<>();
	    
	    for (String name : tagNames) {
	        String trimmedName = name.trim();
	        Optional<Tag> existingTag = tagRepo.findBySubject(trimmedName);
	        
	        if (existingTag.isPresent()) {
	            tags.add(existingTag.get());
	        } else {
	            Tag tag = new Tag();
	            tag.setSubject(trimmedName);
	            tags.add(tag);
	        }
	    }
	    return tags;
	}
	
	public Tag findTagBySubject(String subject) {
	    Optional<Tag> optionalTag = tagRepo.findBySubject(subject);
	    return optionalTag.orElse(null);
	}
	
	public List<Tag> findTagByQuestion(Long questionId) {
	    Question question = questionService.findQuestionById(questionId);
	    if (question != null) {
	        return question.getTags();
	    }
	    return new ArrayList<>();
	}


	
	public Tag findTagById(Long id) {
	    Optional<Tag> optionalTag = tagRepo.findById(id);
	    if (optionalTag.isPresent()) {
	        return optionalTag.get();
	    } else {
	        return null;
	    }
	}
	public Tag updateTag(Tag updatedTag) {
		Optional<Tag> optionalTag = tagRepo.findById(updatedTag.getId());
		if (optionalTag.isPresent()) {
			Tag tagToBeUpdated = optionalTag.get();
			return tagRepo.save(tagToBeUpdated);
		}
		return null;
	}

	
	public void deleteTag(Long id) {
		tagRepo.deleteById(id);
	}
	

}
