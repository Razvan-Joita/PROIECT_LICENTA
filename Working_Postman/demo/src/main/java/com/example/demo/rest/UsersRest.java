package com.example.demo.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface UsersRest {
    @PostMapping("/signUp")
    ResponseEntity<String> signUp(@RequestBody Map<String, String> requestMap);
}
