package com.example.userdata.repository;

import java.util.Optional;

import com.example.userdata.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
    Optional<Role> findById(Long roleId);
}
