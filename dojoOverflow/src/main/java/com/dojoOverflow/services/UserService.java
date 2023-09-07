package com.dojoOverflow.services;


import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.dojoOverflow.models.LoginUser;
import com.dojoOverflow.models.User;
import com.dojoOverflow.repositories.UserRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    public User register(User newUser, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }

        Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());

        if (potentialUser.isPresent()) {
            result.rejectValue("email", "Exists", "Email already exists!");
            return null;
        }

        if (!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
            return null;
        }

        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);          
    }

    public User login(LoginUser newLogin, BindingResult result) {
        if (result.hasErrors()) {
            result.rejectValue("loginEmail", "loginError", "User data is not valid");
            return null;
        }

        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getLoginEmail());
        if (!potentialUser.isPresent()) {
        	result.rejectValue("loginEmail", "loginError", "Information not correct");

            return null;
        }

        User user = potentialUser.get();
        if (!BCrypt.checkpw(newLogin.getLoginPassword(), user.getPassword())) {
        	result.rejectValue("loginPassword", "loginError", "Information not correct");

            return null;
        }
        
        return user;
    }

    
    //Used for debugging
    public List<User> allUsers(){
        return userRepo.findAll();
    }
}