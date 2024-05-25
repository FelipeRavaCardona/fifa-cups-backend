package com.piriurna.fifacups.domain.dto.response.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserIdAndNicknameResponse {
    private String id;
    private String nickname;
}
