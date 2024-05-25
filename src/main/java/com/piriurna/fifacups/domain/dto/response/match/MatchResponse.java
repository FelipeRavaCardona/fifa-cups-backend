package com.piriurna.fifacups.domain.dto.response.match;

import com.piriurna.fifacups.domain.dto.response.team.TeamResponse;
import com.piriurna.fifacups.domain.entity.enums.MatchStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MatchResponse {
    private String id;
    private Integer homeScore;
    private Integer awayScore;
    private TeamResponse homeTeam;
    private TeamResponse awayTeam;
    private MatchStatus status;
}
