package com.piriurna.fifacups.domain.entity;

import java.util.UUID;

import com.piriurna.fifacups.domain.entity.interfaces.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class GroupTeamInfo extends BaseEntity {
    @ManyToOne
    private Group group;

    @ManyToOne
    private Team team;

    private int playedMatches;
    private int points;
    private int goals;
    private int goalsTaken;

    public GroupTeamInfo() {
        this.setId(UUID.randomUUID().toString());
    }

    public GroupTeamInfo(Group group, Team team, int points, int goals, int goalsTaken) {
        this.setId(UUID.randomUUID().toString());
        this.group = group;
        this.team = team;
        this.points = points;
        this.goals = goals;
        this.goalsTaken = goalsTaken;
    }
}
