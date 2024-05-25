package com.piriurna.fifacups.domain.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.piriurna.fifacups.domain.entity.enums.TournamentStatus;
import com.piriurna.fifacups.domain.entity.interfaces.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Tournament extends BaseEntity {
    private String name;

    private LocalDateTime startDate;
    
    @Enumerated(EnumType.STRING)
    private TournamentStatus status;

    @ManyToOne
    private User owner;

    @ManyToMany
    @JoinTable(name = "tournament_team", 
               joinColumns = @JoinColumn(name = "tournament_id"), 
               inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> assignedTeams;

    @ManyToMany
    @JoinTable(name = "tournament_entry_request",
               joinColumns = @JoinColumn(name = "torunament_id"),
               inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> entryRequests;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Group> groups;

    @OneToMany
    @JoinColumn(name = "tournament_id")
    private List<Match> knockOutMatches;

    public Tournament() {
        this.setId(UUID.randomUUID().toString());
    }

    public Tournament(String name, LocalDateTime startDate, User owner) {
        this.setId(UUID.randomUUID().toString());
        this.status = TournamentStatus.CONFIGURING;
        this.name = name;
        this.owner = owner;
        this.startDate = startDate;
    }
}
