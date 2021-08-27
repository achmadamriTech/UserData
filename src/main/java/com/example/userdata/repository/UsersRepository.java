package com.example.userdata.repository;



import java.util.Optional;

import com.example.userdata.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByID(Long usersId);
}
