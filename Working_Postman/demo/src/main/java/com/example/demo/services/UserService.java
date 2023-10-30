package com.example.demo.services;

import org.springframework.http.ResponseEntity;

import java.util.Map;


public interface UserService {

    ResponseEntity<String> signUp(Map<String,String> requestMAP);

}
