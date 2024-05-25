package com.piriurna.fifacups.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piriurna.fifacups.domain.entity.Tournament;

public interface ITournamentRepo extends JpaRepository<Tournament, String> {
    
}
