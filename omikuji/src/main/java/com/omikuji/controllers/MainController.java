package com.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	@GetMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
}
