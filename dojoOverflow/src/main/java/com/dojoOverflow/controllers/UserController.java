package com.dojoOverflow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dojoOverflow.models.LoginUser;
import com.dojoOverflow.models.Question;
import com.dojoOverflow.models.Tag;
import com.dojoOverflow.models.User;
import com.dojoOverflow.services.QuestionService;
import com.dojoOverflow.services.TagService;
import com.dojoOverflow.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private UserService userService;

	 @GetMapping("/")
	 public String index(Model model) {
	     model.addAttribute("newUser", new User());
	     model.addAttribute("newLogin", new LoginUser());
	     return "login.jsp";
	 }
	 
	 @GetMapping("/dashboard")
	 public String dashboard(Model model, HttpSession session) {
	     User loggedInUser = (User) session.getAttribute("user");
	     if (loggedInUser == null) {
	         return "redirect:/";
	     }
	     List<Question> listOfQuestions = questionService.allQuestions();
	     List<Tag> listOfTags = tagService.allTags();
	     model.addAttribute("user", loggedInUser);
	     model.addAttribute("questions", listOfQuestions);
	     model.addAttribute("tags", listOfTags);
	     return "dashboard.jsp";
	 }
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
	   session.invalidate();
	   return "redirect:/";
	 }
	 
	 @PostMapping("/register")
	 public String register(@Valid @ModelAttribute("newUser") User newUser, 
	         BindingResult result, Model model, HttpSession session) {
	     User registeredUser = userService.register(newUser, result);
	     if (result.hasErrors()) {
	         model.addAttribute("newLogin", new LoginUser());
	         return "login.jsp";
	     }
	     session.setAttribute("user", registeredUser);
	     return "redirect:/dashboard";  
	 }
	 
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	         BindingResult result, Model model, HttpSession session) {
	     
	     User user = userService.login(newLogin, result);
	 
	     if(result.hasErrors()) {
	         model.addAttribute("newUser", new User());
	         return "login.jsp";
	     }
	     session.setAttribute("user", user);
	     return "redirect:/dashboard";
	 }
	 
	 //Used for debugging
	 @RequestMapping("/listUsers")
	 @ResponseBody
	 public List<User> listUsers() {
	     return userService.allUsers();
	 }

	 
}
