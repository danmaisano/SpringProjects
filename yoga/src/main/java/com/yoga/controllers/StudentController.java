package com.yoga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yoga.models.Student;
import com.yoga.models.User;
import com.yoga.models.YogaClass;
import com.yoga.services.StudentService;
import com.yoga.services.YogaClassService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("user")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private YogaClassService yogaClassService;

    @PostMapping("/addNewStudent")
    public String createStudent(@Valid @ModelAttribute("student") Student student, 
                                BindingResult result, Model model, HttpSession session,
                                @RequestParam("classId") Long classId) {
        if (result.hasErrors()) {
            YogaClass existingClass = yogaClassService.getClassById(classId);
            User loggedInUser = (User) session.getAttribute("user");
            model.addAttribute("yogaClass", existingClass);
            model.addAttribute("user", loggedInUser);
            
            return "displayClass.jsp";
        }
        YogaClass existingClass = yogaClassService.getClassById(classId);
        
        existingClass.getStudents().add(student); 
        
        studentService.addStudent(student);
        yogaClassService.updateClass(existingClass);
        
        return "redirect:/classes/" + classId;
    }
    
    @PostMapping("/addExistingStudent")
    public String addExistingStudent(@RequestParam("existingStudent") String existingStudentName, 
                                     @RequestParam("classId") Long classId, Model model, RedirectAttributes redirectAttributes) {
        YogaClass existingClass = yogaClassService.getClassById(classId);
        
        Student existingStudent = studentService.getStudentByName(existingStudentName);
        
        if (existingStudent != null && !existingClass.getStudents().contains(existingStudent)) {
            existingClass.getStudents().add(existingStudent);
            yogaClassService.updateClass(existingClass);
        }
        else {
            redirectAttributes.addFlashAttribute("errorMessage", "This student is already in this class.");
        }
        
        return "redirect:/classes/" + classId;
    }



    @PutMapping("/student/edit") // Not needed for assignment but may be useful in a real app
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "editStudent.jsp";
        }
        studentService.updateStudent(student);
        return "redirect:/students/dashboard";
    }

    @DeleteMapping("/student/delete/{id}") // Not needed for assignment but may be useful in a real app
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students/dashboard";
    }

}
