package com.example.userdata.controller;

import com.example.userdata.service.RoleService;
import com.example.userdata.entity.Role;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/role")
public class RoleController {
    
    private RoleService roleService;


    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // Get Semua Data
    @GetMapping("")
    public List<Role> getAllRole() {
        return roleService.getAllRole();
    }

    // Get DataById
    @GetMapping("/{roleId}")
    public Role getRoleById(@PathVariable(name = "roleId") Long roleId ){
        return roleService.getRoleById(roleId);
    }
    
    // Insert Data
    @PostMapping("")
    public void createRole(@RequestBody final Role role) {
        roleService.createRole(role);
    }

    // Delete Data
    @DeleteMapping("/{roleId}")
    public void deleteRole(@PathVariable final Long roleId){
        roleService.deleteRole(roleId);
    }

    // Update Data
    @PutMapping("/{roleId}")
    public void editRole(@PathVariable final long roleId, @RequestBody final Role role){
        roleService.editRole(roleId, role);
    }
}
