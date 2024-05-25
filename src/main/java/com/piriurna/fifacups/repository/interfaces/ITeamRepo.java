package com.piriurna.fifacups.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piriurna.fifacups.domain.entity.Team;

public interface ITeamRepo extends JpaRepository<Team, String> {
    
}
