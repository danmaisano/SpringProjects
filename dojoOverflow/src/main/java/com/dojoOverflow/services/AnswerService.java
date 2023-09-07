package com.dojoOverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojoOverflow.models.Answer;
import com.dojoOverflow.models.Question;
import com.dojoOverflow.repositories.AnswerRepo;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepo answerRepo;
	
	@Autowired
	private QuestionService questionService;
	
	public Answer addAnswer(Answer newAnswer) {
		return answerRepo.save(newAnswer);
	}
	
	public List<Answer> allAnswers(){
        return answerRepo.findAll();
    }
	
	public Answer findAnswerById(Long id) {
	    Optional<Answer> optionalAnswer = answerRepo.findById(id);
	    if (optionalAnswer.isPresent()) {
	        return optionalAnswer.get();
	    } else {
	        return null;
	    }
	}
	public Answer updateAnswer(Answer updatedAnswer) {
		Optional<Answer> optionalAnswer = answerRepo.findById(updatedAnswer.getId());
		if (optionalAnswer.isPresent()) {
			Answer answerToBeUpdated = optionalAnswer.get();
			return answerRepo.save(answerToBeUpdated);
		}
		return null;
	}
	
	public List<Answer> findAnswersByQuestion(Long questionId) {
	    Question question = questionService.findQuestionById(questionId);
	    if (question != null) {
	        return question.getAnswers();
	    }
	    return new ArrayList<>();
	}

	
	public void deleteAnswer(Long id) {
		answerRepo.deleteById(id);
	}
	

}
