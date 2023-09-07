package com.dojoOverflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojoOverflow.models.Tag;
import com.dojoOverflow.services.TagService;

import jakarta.validation.Valid;

@Controller
public class TagController {
	
	@Autowired
	private TagService tagService;

	@PostMapping("/addTag")
	public String addTag(@Valid @ModelAttribute("newTag") Tag newTag, BindingResult result, Model model) {
		tagService.addTag(newTag, result);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteTag(Model model, @PathVariable Long id ) {
		tagService.deleteTag(id);
		return "redirect:/dashboard";
	}

}