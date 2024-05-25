package com.piriurna.fifacups.domain.dto.response.group;

import java.util.List;

import com.piriurna.fifacups.domain.dto.response.match.MatchResponse;
import com.piriurna.fifacups.domain.dto.response.team.TeamResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GroupResponse {
    private String id;
    private List<TeamResponse> groupTeams;
    private List<MatchResponse> groupMatches;
}
