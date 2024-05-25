package com.piriurna.fifacups.repository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.piriurna.fifacups.domain.dto.response.team.TeamResponse;
import com.piriurna.fifacups.domain.entity.Team;
import com.piriurna.fifacups.repository.interfaces.ITeamRepo;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class TeamRepository {
    private ITeamRepo repo;

    private ModelMapper mapper;

    public TeamResponse saveReturnResponse(Team newTeam) {
        Team team = repo.save(newTeam);
        return mapper.map(team, TeamResponse.class);
    }

    public List<Team> findAllByIdReturnEntity(List<String> ids) {
        return repo.findAllById(ids);
    }
}
