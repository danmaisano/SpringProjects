package com.displayDate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class timeController {
	@GetMapping("/time")
	public String index(Model model) {
		Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("K:mm a");
        String formattedTime = sdf.format(now);
        
        model.addAttribute("time", formattedTime);
        return "time";
		
	}
}
