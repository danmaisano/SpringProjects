package com.students.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.students.models.Dorm;
import com.students.models.Student;
import com.students.services.DormService;
import com.students.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class DormController {
	
	@Autowired
	private DormService dormService;
	@Autowired
	private StudentService studentService;
	
	//Read
	@RequestMapping("/newDorm")
	public String index(Model model) {
	    model.addAttribute("dorm", new Dorm()); 
	    return "addDorm.jsp";
	}
	@RequestMapping("/")
	public String listDorms(Model model) {
		List<Dorm> dorms = dormService.allDorms();
		model.addAttribute("dorms", dorms);
		return "home.jsp";
	}
	@GetMapping("/showDorm/{id}")
	public String showDorm(@PathVariable("id") Long id, Model model) {
	    Dorm dorm = dormService.findDorm(id);
	    List<Student> allStudents = studentService.allStudents();
	    List<Dorm> allDorms = dormService.allDorms();
	    model.addAttribute("allDorms", allDorms);
	    List<Student> filteredStudents = new ArrayList<>();
	    for (Student student : allStudents) {
	        if (student.getDorm() != null && student.getDorm().getId().equals(id)) {
	            filteredStudents.add(student);
	        }
	    }
	    model.addAttribute("allStudents", filteredStudents);
	    if (dorm != null) {
	        model.addAttribute("dorm", dorm);
	        return "showDorm.jsp";
	    } else {
	        return "notFound.jsp";
	    }
	}


	//Create

	@PostMapping("/addDorm")
	public String create(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	System.out.println(result.getAllErrors());
            List<Dorm> dorms = dormService.allDorms();
            model.addAttribute("dorms", dorms);
            return "addDorm.jsp";
        } else {
            dormService.createDorm(dorm);
            System.out.println("added");
            return "redirect:/";
        }
    }
	
	//Update
	@RequestMapping("/dorm/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model) {
		Dorm dorm = dormService.findDorm(id);
		model.addAttribute("dorm", dorm);
		return "edit.jsp";
	}
	@RequestMapping(value="/dorm/{id}", method=RequestMethod.PUT)
		public String update(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result, Model model) {
		if (result.hasErrors()) {
            model.addAttribute("dorm", dorm);
            return "edit.jsp";
        } else {
            dormService.updateDorm(dorm);
            return "redirect:/dorm";
        }
	}
	//Delete
	@DeleteMapping("/dorm/delete/{id}")
	public String destroy(@PathVariable("id")Long id) {
		dormService.deleteDorm(id);
		return "redirect:/dorm";
	}
	
	
	
}