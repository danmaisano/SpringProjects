package com.students.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.students.models.Dorm;
import com.students.models.Student;
import com.students.services.DormService;
import com.students.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private DormService dormService;
	
	//Read
	@RequestMapping("/addStudent")
	public String index(Model model) {
	    model.addAttribute("student", new Student());
    	List<Dorm> allDorms = dormService.allDorms();
        model.addAttribute("allDorms", allDorms);
	    return "addStudent.jsp";
	}
	@RequestMapping("/listStudents")
	public String listStudents(Model model) {
		List<Student> students = studentService.allStudents();
		model.addAttribute("students", students);
		return "listStudents.jsp";
	}
	@GetMapping("/students/{id}")
    public String showStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentService.findStudent(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "showStudent.jsp";
        } else {
            return "notFound.jsp";
        }
    }



	//Create

	@PostMapping("/createStudent")
	public String create(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        System.out.println(result.getAllErrors());
	        List<Dorm> allDorms = dormService.allDorms();
	        model.addAttribute("allDorms", allDorms);
	        return "addStudent.jsp";
	    } else {
	        studentService.createStudent(student);
	        return "redirect:/";
	    }
	}
	
	//Update
	@RequestMapping("/student/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model) {
		Student student = studentService.findStudent(id);
		model.addAttribute("student", student);
		return "edit.jsp";
	}
	@RequestMapping(value="/student/{id}", method=RequestMethod.PUT)
		public String update(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "edit.jsp";
        } else {
            studentService.updateStudent(student);
            return "redirect:/student";
        }
	}
	
	@PostMapping("/assignStudentToDorm")
	public String assignStudentToDorm(@RequestParam("dormId") Long dormId, 
	                                  @RequestParam("studentId") Long studentId,
	                                  @RequestParam("newDormId") Long newDormId) {
	    studentService.assignStudentToDorm(studentId, newDormId);
	    return "redirect:/showDorm/" + dormId;
	}



	
	//Delete
	@PostMapping("/student/delete/{id}")
	public String destroy(@PathVariable("id") Long id, @RequestParam("dormId") Long dormId) {
	    studentService.deleteStudent(id);
	    return "redirect:/showDorm/" + dormId;
	}

	
	
	
}