package com.piriurna.fifacups.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piriurna.fifacups.domain.dto.request.tournament.AssignTeamsTournamentDTO;
import com.piriurna.fifacups.domain.dto.request.tournament.CreateTournamentDTO;
import com.piriurna.fifacups.domain.dto.response.tournament.TournamentResponse;
import com.piriurna.fifacups.service.TournamentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/tournament")
@AllArgsConstructor
public class TournamentController {
    private TournamentService service;

    @PostMapping
    public ResponseEntity<TournamentResponse> create(@RequestAttribute String uid, @Valid @RequestBody CreateTournamentDTO data) {
        return service.create(uid, data);
    }

    @PatchMapping("/{id}/assign-teams")
    public ResponseEntity<TournamentResponse> assignTeams(@RequestAttribute String uid, @PathVariable String id, @RequestBody AssignTeamsTournamentDTO data) {
        return service.assignTeams(uid, id, data);
    }
}
