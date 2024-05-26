package com.piriurna.fifacups.domain.dto.request.tournament;

import java.util.List;

import lombok.Data;

@Data
public class AssignTeamsTournamentDTO {
    List<String> teamsIds;
}
