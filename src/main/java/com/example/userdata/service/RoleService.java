package com.example.userdata.service;

import java.util.List;
import java.util.Optional;

import com.example.userdata.entity.Role;
import com.example.userdata.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    // Get Semua Data
    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }

    // Get Data Berdasarkan ID
    public Role getRoleById(Long roleId){
        Optional<Role> role = roleRepository.findById(roleId);

        if (role.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role tidak Ditemukan!");
        }
        return role.get();
    }


}
