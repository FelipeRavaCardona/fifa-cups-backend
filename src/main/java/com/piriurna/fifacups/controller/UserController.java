package com.piriurna.fifacups.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    @PostMapping("/register")
    public ResponseEntity<String> register() {
        return new ResponseEntity<String>("Everything ok", HttpStatus.OK);
    }
}
