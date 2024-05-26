package com.piriurna.fifacups.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.piriurna.fifacups.domain.dto.request.tournament.AssignTeamsTournamentDTO;
import com.piriurna.fifacups.domain.dto.request.tournament.CreateTournamentDTO;
import com.piriurna.fifacups.domain.dto.response.tournament.TournamentResponse;
import com.piriurna.fifacups.domain.entity.Group;
import com.piriurna.fifacups.domain.entity.Match;
import com.piriurna.fifacups.domain.entity.Team;
import com.piriurna.fifacups.domain.entity.Tournament;
import com.piriurna.fifacups.domain.entity.User;
import com.piriurna.fifacups.exceptions.ForbiddenException;
import com.piriurna.fifacups.exceptions.NotFoundException;
import com.piriurna.fifacups.exceptions.UnexpectedException;
import com.piriurna.fifacups.repository.TeamRepository;
import com.piriurna.fifacups.repository.TournamentRepository;
import com.piriurna.fifacups.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TournamentService {
    private TournamentRepository tournamentRepo;
    private UserRepository userRepo;
    private TeamRepository teamRepo;
    
    public ResponseEntity<TournamentResponse> create(String uid, CreateTournamentDTO data) {
        Tournament newTournament = new Tournament(data.getName(), data.getStartDate(), userRepo.findByUidReturnEntity(uid));
        newTournament.setEntryRequests(new ArrayList<Team>());
        newTournament.setGroups(new ArrayList<Group>());
        newTournament.setKnockOutMatches(new ArrayList<Match>());
        if (data.getTeamsIds() != null) {
            List<Team> teams = new ArrayList<Team>(teamRepo.findAllByIdReturnEntity(data.getTeamsIds()));
            newTournament.setAssignedTeams(teams);
        } else {
            newTournament.setAssignedTeams(new ArrayList<Team>());
        }

        try {
            TournamentResponse tournament = tournamentRepo.saveReturnResponse(newTournament);
            return new ResponseEntity<TournamentResponse>(tournament, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new UnexpectedException();
        }
    }

    public ResponseEntity<TournamentResponse> assignTeams(String uid, String id, AssignTeamsTournamentDTO data) {
        User owner = userRepo.findByUidReturnEntity(uid);
        Optional<Tournament> optionalTournament = tournamentRepo.findByIdReturnEntity(id);
        if (!optionalTournament.isPresent()) { 
            throw new NotFoundException("A Tournament with the provided id was not found");
        }
        Tournament tournament = optionalTournament.get();
        if (tournament.getOwner().getId() != owner.getId()) {
            throw new ForbiddenException("You are not the owner of this Tournament");
        }
        List<Team> teams = tournament.getAssignedTeams();
        teams.addAll(teamRepo.findAllByIdReturnEntity(data.getTeamsIds()));
        tournament.setAssignedTeams(teams);
        try {
            TournamentResponse updatedTournament = tournamentRepo.saveReturnResponse(tournament);
            return new ResponseEntity<TournamentResponse>(updatedTournament, HttpStatus.OK);
        } catch (Exception e) {
            throw new UnexpectedException();
        }
    }
}
