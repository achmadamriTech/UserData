package com.example.userdata.service;

import java.util.List;
import java.util.Optional;

import com.example.userdata.entity.Users;
import com.example.userdata.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsersService {
   @Autowired
   private UsersRepository usersRepository;
   
        // Get Semua Data
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    // Get Data Berdasarkan ID
    public Users getUsersById(Long usersId){
        Optional<Users> users = usersRepository.findById(usersId);

        if (users.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Users tidak Ditemukan!");
        }
        return users.get();
    }
}
