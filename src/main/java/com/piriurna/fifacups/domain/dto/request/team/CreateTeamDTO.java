package com.piriurna.fifacups.domain.dto.request.team;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateTeamDTO {
    @NotBlank(message = "'name' is required")
    String name;

    String imageUrl;
}
