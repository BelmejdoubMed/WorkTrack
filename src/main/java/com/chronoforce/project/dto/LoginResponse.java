package com.chronoforce.project.dto;

import com.chronoforce.project.entity.Admin;

public class LoginResponse {
    private Admin admin;
    private String token;
    private String message;
    private boolean success;
    
    // Default constructor
    public LoginResponse() {}
    
    // Constructor for successful login with token
    public LoginResponse(Admin admin, String token) {
        this.admin = admin;
        this.token = token;
        this.success = true;
        this.message = "Login successful";
    }
    
    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }
    
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
}