package com.example.userdata.service;

import java.util.List;

import com.example.userdata.entity.Users;
import com.example.userdata.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
   @Autowired
   private UsersRepository usersRepository;
   
        // Get Semua Data
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }
}
