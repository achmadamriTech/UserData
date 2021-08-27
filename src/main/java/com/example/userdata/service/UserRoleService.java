package com.example.userdata.service;

import java.util.List;

import com.example.userdata.entity.UserRole;
import com.example.userdata.repository.UserRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    // GetAllData
    public List<UserRole> getAllUserRole(){
        return userRoleRepository.findAll();
    }
}
