package com.example.demo.servicesImplementation;

import com.example.demo.constants.AutosConstants;
import com.example.demo.models.Users;
import com.example.demo.repositories.UsersDAO;
import com.example.demo.services.UserService;
import com.example.demo.utils.AutoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;


@Slf4j
@Service
public class UsersServiceImplementation implements UserService {

    @Autowired
    UsersDAO usersDAO;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMAP) {
        log.info("Inside signUp: {}", requestMAP);

        if (validateSignUpMAP(requestMAP)) {
            String email = requestMAP.get("email");
            Users existingUser = usersDAO.findByEmail(email);

            if (existingUser == null) {
                Users newUser = getUserFromMap(requestMAP);
                usersDAO.save(newUser);
                return ResponseEntity.status(HttpStatus.OK).body("Successfully Registered and stored in the database");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AutosConstants.INVALID_DATA);
        }
    }

    private boolean validateSignUpMAP(Map<String,String> requestMAP) {
        return requestMAP.containsKey("name") &&
                requestMAP.containsKey("phone_Number") &&
                requestMAP.containsKey("email") &&
                requestMAP.containsKey("password");
    }

    private Users getUserFromMap(Map<String,String> requestMAP) {
        Users users = new Users();
        users.setName(requestMAP.get("name"));
        users.setPhoneNumber(requestMAP.get("phone_Number"));
        users.setEmail(requestMAP.get("email"));
        users.setPassword(requestMAP.get("password"));
        users.setStatus("false");
        users.setRoles("users");
        return users;
    }
}
