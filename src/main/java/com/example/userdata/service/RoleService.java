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

    // Insert data
    public void createRole(Role role) {
        Optional<Role> roleOptional = roleRepository.findById(role.getID());

        if (roleOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Role Sudah Ada");
        }
        else {
            roleRepository.save(role);
            throw new ResponseStatusException(HttpStatus.OK, "User berhasil Diinput");
        }
        
    }

    // Delete Data
    public void deleteRole(Long roleId){
        Optional<Role> roleOptional = roleRepository.findById(roleId);

        if (roleOptional.isPresent()) {
            roleRepository.deleteById(roleId);
            throw new ResponseStatusException(HttpStatus.OK,"Data Berhasil Di hapus!");
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT," Data Tidak Ditemukan!");
        }
    }

    // Update Data
    public void editRole(Long roleId, Role role){
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        
        if (roleOptional.isPresent()) {
            roleRepository.save(role);
            throw new ResponseStatusException(HttpStatus.OK,"Data berhasil Diubah");
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Data Tidak Ditemukan!");
        }
    }


}
