package com.yoga.services;


import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.yoga.models.LoginUser;
import com.yoga.models.User;
import com.yoga.repositories.UserRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    public User register(User newUser, BindingResult result) {

        Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());

        if (potentialUser.isPresent()) {
            result.rejectValue("email", "Exists", "Email already exists!");
            return null;
        }

        if (!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
            return null;
        }
        
        if (result.hasErrors()) {
        	return null;
        }

        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);          
    }

    public User login(LoginUser newLogin, BindingResult result) {
        if (result.hasErrors()) {
            result.rejectValue("loginEmail", "loginError", "Information is not correct");
            return null;
        }

        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getLoginEmail());
        if (!potentialUser.isPresent()) {
        	result.rejectValue("loginEmail", "loginError", "Information is not correct");

            return null;
        }

        User user = potentialUser.get();
        if (!BCrypt.checkpw(newLogin.getLoginPassword(), user.getPassword())) {
        	result.rejectValue("loginPassword", "loginError", "Information is not correct");

            return null;
        }
        
        return user;
    }
    
    public User findByName(String name) {
        Optional<User> optionalUser = userRepo.findByName(name);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }


    
    //Used for debugging
    public List<User> allUsers(){
        return userRepo.findAll();
    }
}