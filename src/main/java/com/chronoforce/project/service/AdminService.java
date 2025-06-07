package com.chronoforce.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chronoforce.project.entity.Admin;
import com.chronoforce.project.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin findById(int id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin update(int id, Admin admin) {
        admin.setId(id);
        return adminRepository.save(admin);
    }

    public void delete(int id) {
        adminRepository.deleteById(id);
    }
}