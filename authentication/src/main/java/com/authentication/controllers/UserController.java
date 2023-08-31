package com.authentication.controllers;
//.. don't forget to include all your imports! ..

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

import com.authentication.models.FavsForm;
import com.authentication.models.LoginUser;
import com.authentication.models.User;
import com.authentication.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
 	private UserService userService;
 
 @GetMapping("/")
 public String index(Model model) {
     model.addAttribute("newUser", new User());
     model.addAttribute("newLogin", new LoginUser());
     return "login.jsp";
 }
 
 @GetMapping("/favs")
 public String favs(Model model) {
	 return "onboarding.jsp";
 }
 
 @GetMapping("/dashboard")
 public String dashboard(Model model, HttpSession session) {
     User loggedInUser = (User) session.getAttribute("user");
     if (loggedInUser == null) {
         return "redirect:/";
     }
     model.addAttribute("user", loggedInUser);
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
     return "redirect:/favs";  
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
 
 @PostMapping("/submitFavs")
 public String submitFavs(@ModelAttribute FavsForm form, HttpSession session) {
     User user = (User) session.getAttribute("user");
     if (user == null) {
         return "redirect:/";
     }
     User updatedUser = userService.updateUserFavs(user, form.getFavBook(), form.getFavFood(), form.getFavPet(), form.getFavCodingLanguage());
     session.setAttribute("user", updatedUser);
     return "redirect:/dashboard";
 }



 
 //Used for debugging
 @RequestMapping("/listUsers")
 @ResponseBody
 public List<User> listUsers() {
     return userService.allUsers();
 }

 
}
