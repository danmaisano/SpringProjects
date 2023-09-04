package com.bookClub.controllers;

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

import com.bookClub.models.Book;
import com.bookClub.models.LoginUser;
import com.bookClub.models.User;
import com.bookClub.services.BookService;
import com.bookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
 	private UserService userService;
	
	@Autowired
	private BookService bookService;
 
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
     List<Book> listOfBooks = bookService.allBooks();
     model.addAttribute("user", loggedInUser);
     model.addAttribute("books", listOfBooks);
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