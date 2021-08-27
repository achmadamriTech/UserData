package com.example.userdata.controller;

import java.util.List;

import com.example.userdata.entity.Users;
import com.example.userdata.service.UsersService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

    // Get Data Berdasarkan ID
    @GetMapping("/{usersId}")
    public Users getUsersById(@PathVariable(name = "usersId") Long usersId ){
        return usersService.getUsersById(usersId);
    }

    // Insert Data
    @PostMapping("")
    public void createUsers(@RequestBody final Users users) {
        usersService.createUsers(users);
    }

    // Delete Data
    @DeleteMapping("/{usersId}")
    public void deleteUsers(@PathVariable final Long usersId){
        usersService.deleteUsers(usersId);
    }
}
