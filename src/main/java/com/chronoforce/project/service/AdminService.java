package com.chronoforce.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chronoforce.project.entity.Admin;
import com.chronoforce.project.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> findByUserName(String userName) {
        return userName != null ? adminRepository.findByUserName(userName) : null;
    }
    
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin findById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }
    
    

//    public Admin save(Admin admin) {
//        return adminRepository.save(admin);
//    }

    public Admin update(Long id, Admin admin) {
        admin.setId(id);
        return adminRepository.save(admin);
    }

    public void delete(Long id) {
        adminRepository.deleteById(id);
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin save(Admin admin) {
        // Hash password before saving
        if (admin.getPassword() != null && !admin.getPassword().isEmpty()) {
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        }
        return adminRepository.save(admin);
    }
}