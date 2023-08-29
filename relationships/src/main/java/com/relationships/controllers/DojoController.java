package com.relationships.controllers;

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

import com.relationships.models.Dojo;
import com.relationships.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojoService;
	
	//Read
	@RequestMapping("/newDojo")
	public String index(Model model) {
	    model.addAttribute("dojo", new Dojo()); 
	    return "dojo.jsp";
	}
	@RequestMapping("/listDojos")
	public String listDojos(Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "listDojos.jsp";
	}
	@GetMapping("/dojos/{id}")
    public String showDojo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.findDojo(id);
        if (dojo != null) {
            model.addAttribute("dojo", dojo);
            return "showDojo.jsp";
        } else {
            return "notFound.jsp";
        }
    }



	//Create

	@PostMapping("/addDojo")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	System.out.println(result.getAllErrors());
            List<Dojo> dojos = dojoService.allDojos();
            model.addAttribute("dojos", dojos);
            return "dojo.jsp";
        } else {
            dojoService.createDojo(dojo);
            System.out.println("added");
            return "redirect:/listDojos";
        }
    }
	
	//Update
	@RequestMapping("/dojo/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "edit.jsp";
	}
	@RequestMapping(value="/dojo/{id}", method=RequestMethod.PUT)
		public String update(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
            model.addAttribute("dojo", dojo);
            return "edit.jsp";
        } else {
            dojoService.updateDojo(dojo);
            return "redirect:/dojo";
        }
	}
	//Delete
	@DeleteMapping("/dojo/delete/{id}")
	public String destroy(@PathVariable("id")Long id) {
		dojoService.deleteDojo(id);
		return "redirect:/dojo";
	}
	
	
	
}