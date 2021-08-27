package com.example.userdata.controller;

import com.example.userdata.service.UserRoleService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {
    
    private UserRoleService userRoleService;


    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

}
