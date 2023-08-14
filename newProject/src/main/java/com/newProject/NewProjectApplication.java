package com.newProject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
// 1. Annotation
@RestController
public class NewProjectApplication {
        public static void main(String[] args) {
                SpringApplication.run(NewProjectApplication.class, args);
        }
        
//        // 1. Annotation
//        @RequestMapping("/")
//        // 3. Method that maps to the request route above
//        public String index() { // 3
//                return "Hello World";
//        }
        @RequestMapping("/custom")
        // 3. Method that maps to the request route above
        public String custom() { // 3
        	return "Hello Sexy";
        }
}

