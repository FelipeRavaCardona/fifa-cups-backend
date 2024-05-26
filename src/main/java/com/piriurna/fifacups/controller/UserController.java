package com.piriurna.fifacups.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piriurna.fifacups.domain.dto.request.user.RegisterUserDTO;
import com.piriurna.fifacups.domain.dto.response.user.UserBasicResponse;
import com.piriurna.fifacups.domain.dto.response.user.UserResponse;
import com.piriurna.fifacups.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> register(@RequestAttribute String uid, @RequestAttribute String email, @Valid @RequestBody RegisterUserDTO data) {
        return service.register(uid, email, data);
    }

    @GetMapping
    public ResponseEntity<UserBasicResponse> get(@RequestAttribute String uid, @RequestAttribute String email) {
        return service.get(uid, email);
    }
}
