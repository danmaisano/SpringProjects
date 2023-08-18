package com.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

@Controller
public class ShowController {
	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		model.addAttribute("pickNumber", session.getAttribute("pickNumber"));
		model.addAttribute("pickCity", session.getAttribute("pickCity"));
		model.addAttribute("pickPerson", session.getAttribute("pickPerson"));
		model.addAttribute("pickHobby", session.getAttribute("pickHobby"));
		model.addAttribute("pickAnimal", session.getAttribute("pickAnimal"));
		model.addAttribute("pickSaying", session.getAttribute("pickSaying"));
		return "show.jsp";
	}
}
