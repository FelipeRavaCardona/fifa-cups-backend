package com.piriurna.fifacups.domain.dto.response.team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TeamResponse {
    private String id;
    private String name;
    private String imageUrl;
    private String ownerNickname;
}
