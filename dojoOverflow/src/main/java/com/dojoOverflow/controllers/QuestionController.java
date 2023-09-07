package com.dojoOverflow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dojoOverflow.models.Answer;
import com.dojoOverflow.models.Question;
import com.dojoOverflow.models.Tag;
import com.dojoOverflow.models.User;
import com.dojoOverflow.services.AnswerService;
import com.dojoOverflow.services.QuestionService;
import com.dojoOverflow.services.TagService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private AnswerService answerService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.setDisallowedFields("tags");
	}
	
	@GetMapping("/question/{id}")
	public String questionDetails(@PathVariable Long id, Model model, HttpSession session) {
	    Question question = questionService.findQuestionById(id);
	    model.addAttribute("question", question);
	    User loggedInUser = (User) session.getAttribute("user");
	    model.addAttribute("user", loggedInUser);
	    List<Tag> tags = tagService.findTagByQuestion(id);
	    model.addAttribute("tags", tags);
	    model.addAttribute("question", question);
	    List<Answer> answers = answerService.findAnswersByQuestion(id);
	    model.addAttribute("answers", answers);

	    return "showQuestion.jsp";
	}
	
	@GetMapping("/addQuestion")
	public String addNewQuestion(Model model, HttpSession session) {
	    model.addAttribute("newQuestion", new Question());
	    User loggedInUser = (User) session.getAttribute("user");
	    model.addAttribute("user", loggedInUser);
	    return "addQuestion.jsp";
	}
	
	@GetMapping("/edit/question/{id}")
	public String editQuestion(@PathVariable Long id, Model model, HttpSession session) {
		Question question = questionService.findQuestionById(id);
	    model.addAttribute("updatedQuestion", question);
	    User loggedInUser = (User) session.getAttribute("user");
	    model.addAttribute("user", loggedInUser);
	    return "editQuestion.jsp";
	}

	@PostMapping("/addQuestion")
	public String addQuestion(@Valid @ModelAttribute("newQuestion") Question newQuestion,
	                          @RequestParam("tags") String tagString,
	                          BindingResult result, Model model, HttpSession session) {
	    User loggedInUser = (User) session.getAttribute("user");
	    if (loggedInUser == null) {
	        return "redirect:/";
	    }
	    if (result.hasErrors()) {
	        model.addAttribute("newQuestion", newQuestion);
	        return "addQuestion.jsp";
	    }

	    List<Tag> tags = tagService.createTagsFromForm(tagString);


	    for (Tag tag : tags) {
	        if (tag.getId() == null) {
	            tagService.addTag(tag, result);
	        }
	    }
	    
	    newQuestion.setTags(tags);
	    newQuestion.setPostedBy(loggedInUser);
	    questionService.addQuestion(newQuestion);
	    
	    return "redirect:/dashboard";
	}


	






	
	@PatchMapping("/editQuestion")
	public String editQuestion(@Valid @ModelAttribute("updatedQuestion") Question updatedQuestion, BindingResult result, Model model, HttpSession session) {
	    User loggedInUser = (User) session.getAttribute("user");
	    if (loggedInUser == null) {
	        return "redirect:/";
	    }

	    Question originalQuestion = questionService.findQuestionById(updatedQuestion.getId());
	    
	    if (result.hasErrors()) {
	        updatedQuestion.setId(originalQuestion.getId());
	        model.addAttribute("updatedQuestion", updatedQuestion);
	        return "editQuestion.jsp";
	    }

	    if (originalQuestion.getPostedBy().getId().equals(loggedInUser.getId())) {
	        if (updatedQuestion.getQuestion() != null) {
	            originalQuestion.setQuestion(updatedQuestion.getQuestion());
	        }
	        
	        questionService.updateQuestion(originalQuestion);
	        return "redirect:/dashboard";
	    } else {
	        return "redirect:/dashboard";
	    }
	}


	
	@DeleteMapping("/delete/question/{id}")
	public String deleteQuestion(Model model, @PathVariable Long id ) {
		questionService.deleteQuestion(id);
		return "redirect:/dashboard";
	}

}