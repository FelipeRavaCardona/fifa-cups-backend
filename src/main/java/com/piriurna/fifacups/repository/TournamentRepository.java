package com.piriurna.fifacups.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.piriurna.fifacups.config.modelMapper.TournamentMapper;
import com.piriurna.fifacups.domain.dto.response.tournament.TournamentResponse;
import com.piriurna.fifacups.domain.entity.Tournament;
import com.piriurna.fifacups.repository.interfaces.ITournamentRepo;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class TournamentRepository {
    private ITournamentRepo repo;

    private TournamentMapper mapper;

    public TournamentResponse saveReturnResponse(Tournament newTournament) {
        Tournament tournament = repo.save(newTournament);
        return mapper.mapToResponse(tournament);
    }

    public Optional<Tournament> findByIdReturnEntity(String id) {
        return repo.findById(id);
    }
}
