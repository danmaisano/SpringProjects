package com.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CountController {
	@GetMapping("/counter")
	public String index(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if (count == null) {
			count = 0;
		} else {
			count++;
		}
		session.setAttribute("count", count);
		return "index.jsp";
	}
}
