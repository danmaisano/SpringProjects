package com.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
@Controller
public class SubmitController {
	@PostMapping("/submit")
	public String submit(HttpSession session) {
		session.getAttribute("pickNumber");
		session.getAttribute("pickCity");
		session.getAttribute("pickName");
		session.getAttribute("pickHobby");
		session.getAttribute("pickAnimal");
		session.getAttribute("pickSaying");
		return "redirect:/omikuji/show";
	}
}
