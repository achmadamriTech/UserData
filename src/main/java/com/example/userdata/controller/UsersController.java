package com.example.userdata.controller;

import java.util.List;

import com.example.userdata.entity.Users;
import com.example.userdata.service.UsersService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    private UsersService usersService;


    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    // Get Semua Data
    @GetMapping("")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/{usersId}")
    public Users getUsersById(@PathVariable(name = "usersId") Long usersId ){
        return usersService.getUsersById(usersId);
    }
}
