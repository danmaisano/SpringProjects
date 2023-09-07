package com.dojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojoOverflow.models.Question;
import com.dojoOverflow.repositories.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	public Question addQuestion(Question newQuestion) {
        return questionRepo.save(newQuestion);
    }
	
	public List<Question> allQuestions(){
        return questionRepo.findAll();
    }
	
	public Question findQuestionById(Long id) {
	    Optional<Question> optionalQuestion = questionRepo.findById(id);
	    if (optionalQuestion.isPresent()) {
	        return optionalQuestion.get();
	    } else {
	        return null;
	    }
	}
	public Question updateQuestion(Question updatedQuestion) {
		Optional<Question> optionalQuestion = questionRepo.findById(updatedQuestion.getId());
		if (optionalQuestion.isPresent()) {
			Question questionToBeUpdated = optionalQuestion.get();
			return questionRepo.save(questionToBeUpdated);
		}
		return null;
	}

	
	public void deleteQuestion(Long id) {
		questionRepo.deleteById(id);
	}
	

}
