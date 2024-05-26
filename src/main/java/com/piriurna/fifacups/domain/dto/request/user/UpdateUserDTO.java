package com.piriurna.fifacups.domain.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateUserDTO {
    @NotBlank(message = "'nickname' is required")
    String nickname;
}
