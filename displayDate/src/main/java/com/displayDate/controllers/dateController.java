package com.displayDate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dateController {
	@GetMapping("/date")
	public String index(Model model) {
		Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("E, MMMM dd, yyyy");
        String formattedDate = sdf.format(now);
        
        model.addAttribute("date", formattedDate);
        return "date";
	}
}
