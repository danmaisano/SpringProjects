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
import com.relationships.models.Ninja;
import com.relationships.services.DojoService;
import com.relationships.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	
	//Read
	@RequestMapping("/ninja")
	public String index(Model model) {
	    List<Ninja> ninjas = ninjaService.allNinjas();
	    model.addAttribute("ninjas", ninjas);
	    model.addAttribute("ninja", new Ninja()); 
    	List<Dojo> allDojos = dojoService.allDojos();
        model.addAttribute("allDojos", allDojos);
	    return "ninja.jsp";
	}
	@GetMapping("/ninja/{id}")
    public String showNinja(@PathVariable("id") Long id, Model model) {
        Ninja ninja = ninjaService.findNinja(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "home.jsp";
        } else {
            return "notFound.jsp";
        }
    }

	//Create

	@PostMapping("/addNinja")
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	System.out.println(result.getAllErrors());
            List<Ninja> ninjas = ninjaService.allNinjas();
            model.addAttribute("ninjas", ninjas);
            return "ninja.jsp";
        } else {
            ninjaService.createNinja(ninja);
            System.out.println("added");
            return "redirect:/";
        }
    }
	
	//Update
	@RequestMapping("/ninja/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model) {
		Ninja ninja = ninjaService.findNinja(id);
		model.addAttribute("ninja", ninja);
		return "edit.jsp";
	}
	@RequestMapping(value="/ninja/{id}", method=RequestMethod.PUT)
		public String update(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
            model.addAttribute("ninja", ninja);
            return "edit.jsp";
        } else {
            ninjaService.updateNinja(ninja);
            return "redirect:/ninjas";
        }
	}
	//Delete
	@DeleteMapping("/ninja/delete/{id}")
	public String destroy(@PathVariable("id")Long id) {
		ninjaService.deleteNinja(id);
		return "redirect:/ninja";
	}
	
	//Didn't seem worth making a new controller for a home page
	@GetMapping("/")
	public String showHomePage() {
	    return "home.jsp"; 
	}
	
	
}