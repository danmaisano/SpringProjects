package com.yoga.models;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
    
public class LoginUser {
    
    @NotEmpty(message="Email is required!")
    private String loginEmail;
    
    @NotEmpty(message="Password is required!")
    private String loginPassword;
    
    public LoginUser() {}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


    

    
}
