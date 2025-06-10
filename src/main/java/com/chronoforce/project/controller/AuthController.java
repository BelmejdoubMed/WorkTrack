package com.chronoforce.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chronoforce.project.dto.LoginRequest;
import com.chronoforce.project.dto.LoginResponse;
import com.chronoforce.project.entity.Admin;
import com.chronoforce.project.service.JwtService; // Add this import

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtService jwtService; // Add this injection

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getUserName(),
                    loginRequest.getPassword()
                )
            );

            Admin admin = (Admin) authentication.getPrincipal();
            
            // Generate JWT token
            String token = jwtService.generateToken(admin);
            
            // Create response with admin and token
            LoginResponse response = new LoginResponse(admin, token);
            
            return ResponseEntity.ok(response);
            
        } catch (AuthenticationException e) {
            LoginResponse errorResponse = new LoginResponse();
            errorResponse.setMessage("Invalid username or password");
            errorResponse.setSuccess(false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}