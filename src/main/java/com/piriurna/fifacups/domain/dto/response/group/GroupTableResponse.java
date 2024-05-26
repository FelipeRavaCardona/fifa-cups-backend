package com.piriurna.fifacups.domain.dto.response.group;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GroupTableResponse {
    private String id;
    private String teamId;
    private String groupId;
    private int playedMatches;
    private int points;
    private int goals;
    private int goalsTaken;
}
