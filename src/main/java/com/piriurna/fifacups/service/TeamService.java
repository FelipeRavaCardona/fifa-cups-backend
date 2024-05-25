package com.piriurna.fifacups.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.piriurna.fifacups.domain.dto.request.team.CreateTeamDTO;
import com.piriurna.fifacups.domain.dto.response.team.TeamResponse;
import com.piriurna.fifacups.domain.entity.Team;
import com.piriurna.fifacups.domain.entity.User;
import com.piriurna.fifacups.exceptions.DuplicateEntryException;
import com.piriurna.fifacups.exceptions.UnexpectedException;
import com.piriurna.fifacups.repository.TeamRepository;
import com.piriurna.fifacups.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeamService {
    private TeamRepository teamRepo;
    private UserRepository userRepo;

    public ResponseEntity<TeamResponse> create(String uid, CreateTeamDTO data) {
        User owner = userRepo.findByUidReturnEntity(uid);
        Team newTeam = new Team(data.getName(), data.getImageUrl(), owner);
        try {
            TeamResponse team = teamRepo.saveReturnResponse(newTeam);
            return new ResponseEntity<TeamResponse>(team, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEntryException();
        } catch (Exception e ) {
            throw new UnexpectedException();
        }
    }
}
