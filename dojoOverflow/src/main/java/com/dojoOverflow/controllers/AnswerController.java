package com.dojoOverflow.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dojoOverflow.models.Answer;
import com.dojoOverflow.models.Question;
import com.dojoOverflow.models.User;
import com.dojoOverflow.services.AnswerService;
import com.dojoOverflow.services.QuestionService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private QuestionService questionService;
	

	@PostMapping("/addAnswer")
	public String addAnswer(@Valid @ModelAttribute("newAnswer") Answer newAnswer, BindingResult result, Model model, HttpSession session, @RequestParam("question_id") Long question_id) {
	    User loggedInUser = (User) session.getAttribute("user");
	    if (loggedInUser == null) {
	        return "redirect:/";
	    }
	    if (result.hasErrors()) {
	        System.out.println("There were errors:");
	        result.getFieldErrors().forEach(error -> {
	            System.out.println(error.getField() + ": " + error.getDefaultMessage());
	        });
	        model.addAttribute("newAnswer", newAnswer);
	        return "showQuestion.jsp";
	    }

	    
	    Question question = questionService.findQuestionById(question_id);
	    if (question == null) {
	        return "redirect:/dashboard";
	    }
	    
	    newAnswer.setQuestion(question);
	    newAnswer.setAnswerer(loggedInUser);
	    answerService.addAnswer(newAnswer);
	    return "redirect:/dashboard";
	}


		
	@DeleteMapping("/delete/answer/{id}")
	public String deleteAnswer(Model model, @PathVariable Long id ) {
		answerService.deleteAnswer(id);
		return "redirect:/dashboard";
	}

}