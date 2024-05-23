package com.piriurna.fifacups.domain.entity;

import java.util.List;
import java.util.UUID;

import com.piriurna.fifacups.domain.entity.interfaces.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "group_table")
@Getter
@Setter
@ToString
public class Group extends BaseEntity {
    @ManyToOne
    private Tournament tournament;

    @ManyToMany
    @JoinTable(name = "group_team", 
               joinColumns = @JoinColumn(name = "group_id"), 
               inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> groupTeams;

    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Match> groupMatches;

    public Group() {
        this.setId(UUID.randomUUID().toString());
    }

    public Group(Tournament tournament) {
        this.setId(UUID.randomUUID().toString());
        this.tournament = tournament;
    }
}
