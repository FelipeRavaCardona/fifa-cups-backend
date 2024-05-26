package com.piriurna.fifacups.domain.dto.response.group;

import java.util.List;

import com.piriurna.fifacups.domain.dto.response.match.MatchResponse;

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
    private List<GroupTableResponse> groupTable;
    private List<MatchResponse> groupMatches;
}
