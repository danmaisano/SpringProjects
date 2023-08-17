package com.receipt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReceiptController {
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "Grace Hopper";
        String itemName = "Copper wire";
        double price = 5.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "Little Things Corner Store";
    
    	model.addAttribute("name", "Lana Kane");
    	model.addAttribute("itemName", "Rocket Launcher");
    	model.addAttribute("price", "999.99");
    	model.addAttribute("description", "It goes BOOM");
    	model.addAttribute("vendor", "Army Surplus");
    
        return "index.jsp";
    }
}
