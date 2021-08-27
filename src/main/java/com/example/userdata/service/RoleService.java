package com.example.userdata.service;

import java.util.List;

import com.example.userdata.entity.Role;
import com.example.userdata.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    // Get Semua Data
    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }

}
