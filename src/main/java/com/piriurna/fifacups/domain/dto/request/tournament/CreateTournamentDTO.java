package com.piriurna.fifacups.domain.dto.request.tournament;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateTournamentDTO {
    @NotBlank(message = "'name' is required")
    String name;

    @Future(message = "'startDate' must be in the future")
    @NotNull(message = "'startDate' is required")
    LocalDateTime startDate;

    List<String> teamsIds;
}
