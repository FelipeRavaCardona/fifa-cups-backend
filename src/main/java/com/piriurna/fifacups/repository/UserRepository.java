package com.piriurna.fifacups.repository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.piriurna.fifacups.domain.dto.response.user.UserResponse;
import com.piriurna.fifacups.domain.entity.User;
import com.piriurna.fifacups.repository.interfaces.IUserRepo;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UserRepository {
    private IUserRepo repo;

    private ModelMapper mapper;

    public UserResponse saveReturnResponse(User newUser) {
        User user = repo.save(newUser);
        return mapper.map(user, UserResponse.class);
    }
}
