package com.piriurna.fifacups.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piriurna.fifacups.domain.dto.request.team.CreateTeamDTO;
import com.piriurna.fifacups.domain.dto.response.team.TeamResponse;
import com.piriurna.fifacups.service.TeamService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/team")
@AllArgsConstructor
public class TeamController {
    private TeamService service;

    @PostMapping
    public ResponseEntity<TeamResponse> create(@RequestAttribute String uid, @Valid @RequestBody CreateTeamDTO data) {
        return service.create(uid, data);
    }
}
