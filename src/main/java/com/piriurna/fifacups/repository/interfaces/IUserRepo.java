package com.piriurna.fifacups.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piriurna.fifacups.domain.entity.User;

public interface IUserRepo extends JpaRepository<User, String>{
    public User findByUid(String uid);
}
