package com.piriurna.fifacups.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.piriurna.fifacups.domain.dto.request.user.RegisterUserDTO;
import com.piriurna.fifacups.domain.dto.response.user.UserResponse;
import com.piriurna.fifacups.domain.entity.User;
import com.piriurna.fifacups.exceptions.DuplicateEntryException;
import com.piriurna.fifacups.exceptions.UnexpectedException;
import com.piriurna.fifacups.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository repo;

    public ResponseEntity<UserResponse> register(String uid, RegisterUserDTO data) {
        User newUser = new User(uid, data.getNickname(), data.getEmail());
        try {
            UserResponse user = repo.saveReturnResponse(newUser);
            return new ResponseEntity<UserResponse>(user, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEntryException();
        } catch (Exception e) {
            throw new UnexpectedException();
        }
    }
}
