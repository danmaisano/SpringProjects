package com.HelloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

	@RequestMapping("/")
    public String index(
        @RequestParam(value="firstName", required=false, defaultValue="Human") String firstNameInput,
        @RequestParam(value="lastName", required=false, defaultValue="") String lastNameInput,
        @RequestParam(value="numberOfTimes", required=false, defaultValue="1") Integer numberOfTimes
    ) {
        String greeting = "Hello " + firstNameInput + " " + lastNameInput;
        StringBuilder repeatedGreeting = new StringBuilder();
        
        for(int i = 0; i < numberOfTimes; i++) {
            repeatedGreeting.append(greeting);
        }
        
        return repeatedGreeting.toString();
    }
}
