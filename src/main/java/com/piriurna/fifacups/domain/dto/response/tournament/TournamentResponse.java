package com.piriurna.fifacups.domain.dto.response.tournament;

import java.time.LocalDateTime;
import java.util.List;

import com.piriurna.fifacups.domain.dto.response.group.GroupResponse;
import com.piriurna.fifacups.domain.dto.response.team.TeamResponse;
import com.piriurna.fifacups.domain.dto.response.user.UserResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TournamentResponse {
    private String id;
    private String name;
    private String status;
    private UserResponse owner;
    private LocalDateTime startDate;
    private List<TeamResponse> assignedTeams;
    private List<GroupResponse> groups;
    private List<TeamResponse> entryResquests;
}
