package com.piriurna.fifacups.config.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.piriurna.fifacups.domain.dto.response.team.TeamResponse;
import com.piriurna.fifacups.domain.entity.Team;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TeamMapper {
    private final ModelMapper mapper;

    public TeamResponse mapToResponse(Team team) {
        TeamResponse response = mapper.map(team, TeamResponse.class);
        response.getOwner().setId(team.getOwner().getId());
        response.getOwner().setNickname(team.getOwner().getNickname());

        return response;
    }
}
