package com.piriurna.fifacups.config.modelMapper;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.piriurna.fifacups.domain.dto.response.group.GroupResponse;
import com.piriurna.fifacups.domain.dto.response.team.TeamResponse;
import com.piriurna.fifacups.domain.dto.response.tournament.TournamentResponse;
import com.piriurna.fifacups.domain.entity.Tournament;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TournamentMapper {
    private final ModelMapper mapper;

    public TournamentResponse mapToResponse(Tournament tournament) {
        TournamentResponse response = mapper.map(tournament, TournamentResponse.class);

        if (tournament.getAssignedTeams() != null) {
            response.setAssignedTeams(tournament.getAssignedTeams().stream()
                .map(team -> {
                    TeamResponse teamResponse = mapper.map(team, TeamResponse.class);
                    return teamResponse;
                })
                .collect(Collectors.toList())
            );
        }

        if (tournament.getGroups() != null) {
            response.setGroups(tournament.getGroups().stream()
                .map(group -> {
                    GroupResponse groupResponse = mapper.map(group, GroupResponse.class);
                    return groupResponse;
                })
                .collect(Collectors.toList())
            );
        }

        if (tournament.getEntryRequests() != null) {
            response.setEntryResquests(tournament.getEntryRequests().stream()
                .map(team -> {
                    TeamResponse teamResponse = mapper.map(team, TeamResponse.class);
                    return teamResponse;
                })
                .collect(Collectors.toList())
            );
        }

        return response;
    }
}
