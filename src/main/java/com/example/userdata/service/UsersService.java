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

    // Insert data
    public void createUsers(Users users) {
        Optional<Users> userOptional = usersRepository.findByID(users.getID());

        if (userOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User Sudah Ada");
        }
        else {
            usersRepository.save(users);
            throw new ResponseStatusException(HttpStatus.OK, "User berhasil Diinput");
        }
        
    }

    // Delete Data
    public void deleteUsers(Long usersId){
        Optional<Users> usersOptional = usersRepository.findByID(usersId);

        if (usersOptional.isPresent()) {
            usersRepository.deleteById(usersId);
            throw new ResponseStatusException(HttpStatus.OK,"Data Berhasil Di hapus!");
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT," Data Tidak Ditemukan!");
        }
    }

    // Update Data
    public void editUsers(Long usersId, Users users){
        Optional<Users> userOptional = usersRepository.findByID(usersId);
        
        if (userOptional.isPresent()) {
            usersRepository.save(users);
            throw new ResponseStatusException(HttpStatus.OK,"Data berhasil Diubah");
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Data Tidak Ditemukan!");
        }
    }
}
