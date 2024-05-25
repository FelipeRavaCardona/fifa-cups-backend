package com.piriurna.fifacups.domain.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterUserDTO {
    @NotBlank(message = "'nickname' is required")
    String nickname;

    @Email(message = "'email' must be a valid email")
    @NotBlank(message = "'email' is required")
    String email;
}
