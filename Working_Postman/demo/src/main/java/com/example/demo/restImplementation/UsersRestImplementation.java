package com.example.demo.restImplementation;

import com.example.demo.constants.AutosConstants;
import com.example.demo.rest.UsersRest;
import com.example.demo.services.UserService;
import com.example.demo.utils.AutoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/usersEndpoints")
public class UsersRestImplementation implements UsersRest {

    @Autowired
    private UserService userService;

    @Override
    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody Map<String, String> requestMap) {
        try {
            return userService.signUp(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return AutoUtils.getResponseEntity(AutosConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
