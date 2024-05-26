package com.piriurna.fifacups.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.piriurna.fifacups.domain.dto.request.user.RegisterUserDTO;
import com.piriurna.fifacups.domain.dto.request.user.UpdateUserDTO;
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

    public ResponseEntity<UserResponse> register(String uid, String email, RegisterUserDTO data) {
        User newUser = new User(uid, data.getNickname(), email);
        try {
            UserResponse user = repo.saveReturnResponse(newUser);
            return new ResponseEntity<UserResponse>(user, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEntryException();
        } catch (Exception e) {
            throw new UnexpectedException();
        }
    }

    public ResponseEntity<UserResponse> get(String uid, String email) {
        UserResponse user = repo.findByUidReturnResponse(uid);

        if (user == null) {
            User newUser = new User(uid, email, email);
            user = repo.saveReturnResponse(newUser);
        }
            
        return new ResponseEntity<UserResponse>(user, HttpStatus.OK);
    }

    public ResponseEntity<UserResponse> update(String uid, UpdateUserDTO data) {
        User user = repo.findByUidReturnEntity(uid);
        user.setNickname(data.getNickname());
        UserResponse updatedUser = repo.saveReturnResponse(user);
        return new ResponseEntity<UserResponse>(updatedUser, HttpStatus.OK);
    }
}
