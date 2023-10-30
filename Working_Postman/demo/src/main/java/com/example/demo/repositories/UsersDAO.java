package com.example.demo.repositories;

import com.example.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UsersDAO extends JpaRepository<Users, Integer> {

    Users findByEmail(@Param("email") String email);

}
