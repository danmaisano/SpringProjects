package com.yoga.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.yoga.models.Student;
import com.yoga.models.User;
import com.yoga.models.YogaClass;
import com.yoga.services.StudentService;
import com.yoga.services.YogaClassService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class YogaClassController {
  
    @Autowired
    private YogaClassService yogaClassService;
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/dashboard")
    public String showDashboard(Model model, HttpSession session) {
    	User loggedInUser = (User) session.getAttribute("user");
    	if (loggedInUser == null) {
	         return "redirect:/";
	     }
        List<YogaClass> classes = yogaClassService.getAllClasses();
        model.addAttribute("classes", classes);
	    model.addAttribute("user", loggedInUser);
        return "dashboard.jsp";
    }
    
    @GetMapping("/classes/{id}")
    public String displayClass(@PathVariable Long id, Model model, HttpSession session) {
    	User loggedInUser = (User) session.getAttribute("user");
    	if (loggedInUser == null) {
	         return "redirect:/";
	     }
        YogaClass existingClass = yogaClassService.getClassById(id);
        model.addAttribute("yogaClass", existingClass);
        model.addAttribute("user", loggedInUser);
        List<Student> allStudents = studentService.getAllStudents();
        model.addAttribute("allStudents", allStudents);
        return "displayClass.jsp";
    }
    
    @GetMapping("/addClass")
    public String addClassForm(Model model, HttpSession session) {
    	User loggedInUser = (User) session.getAttribute("user");
    	if (loggedInUser == null) {
	         return "redirect:/";
	     }
        model.addAttribute("newClass", new YogaClass());
	    model.addAttribute("user", loggedInUser);
	    return "createClass.jsp";
    }

    @GetMapping("/editClass/{id}")
    public String editClassForm(@PathVariable Long id, Model model, HttpSession session) {
    	User loggedInUser = (User) session.getAttribute("user");
    	if (loggedInUser == null) {
	         return "redirect:/";
	     }
        YogaClass existingClass = yogaClassService.getClassById(id);
	    model.addAttribute("user", loggedInUser);
	    model.addAttribute("existingClass", existingClass);
        return "editClass.jsp";
    }
    

    @PostMapping("/addClass")
    public String addClass(@Valid @ModelAttribute("newClass") YogaClass yogaClass, 
                           BindingResult result,
                           HttpSession session,
                           Model model) {
        User loggedInUser = (User) session.getAttribute("user");
        if (loggedInUser == null) {
             return "redirect:/";
        }

        if (result.hasErrors()) {
            model.addAttribute("newClass", yogaClass);
            model.addAttribute("user", loggedInUser);
            return "createClass.jsp";
        }
        
        yogaClass.setInstructor(loggedInUser);
        yogaClassService.addClass(yogaClass);
        return "redirect:/dashboard";
    }


    @PutMapping("/editClass/{id}")
    public String updateClass(@PathVariable Long id, @Valid @ModelAttribute("existingClass") YogaClass updatedClass, 
                              BindingResult result,
                              HttpSession session,
                              Model model) {
        User loggedInUser = (User) session.getAttribute("user");
        if (loggedInUser == null) {
             return "redirect:/";
        }
        
        if (result.hasErrors()) {
            model.addAttribute("existingClass", updatedClass);
            model.addAttribute("user", loggedInUser);
            return "editClass.jsp";
        }

        updatedClass.setInstructor(loggedInUser);
        yogaClassService.updateClass(updatedClass);
        return "redirect:/dashboard";
    }

    
    @DeleteMapping("/deleteClass/{id}")
    public String deleteClass(@PathVariable Long id) {
        yogaClassService.deleteClass(id);
        return "redirect:/dashboard";
    }
}
