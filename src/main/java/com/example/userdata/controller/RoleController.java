package com.example.userdata.controller;

import com.example.userdata.service.RoleService;
import com.example.userdata.entity.Role;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/role")
public class RoleController {
    
    private RoleService roleService;


    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public List<Role> getAllRole() {
        return roleService.getAllRole();
    }
    
}
