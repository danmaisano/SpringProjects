package com.Daikichi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiController {
	@RequestMapping("/")
	public String welcome() {
		return "Welcome!";
	}
	@RequestMapping("/today")
	public String today() {
		return "Today you will find much luck!";
	}
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "However, tomorrow will probably suck.!";
	}
	
	@RequestMapping("/travel/{city}")
	 public String showTravel(@PathVariable("city") String city){
    	return "Congratulations, you will soon travel to " + city;
    }
	
	@RequestMapping("/lotto/{luckyNumber}")
	public String lotto(@PathVariable("luckyNumber") Integer luckyNumber){
		if (luckyNumber % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of the tempting offers!";
		}
		else {
			return "You have enjoyed the fruits of your labor, but now is a great time to spend time with family and friends!";
		}
	}
}
