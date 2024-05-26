package com.piriurna.fifacups.domain.dto.response.team;

import com.piriurna.fifacups.domain.dto.response.user.UserResponse;

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
    private UserResponse owner;
}
