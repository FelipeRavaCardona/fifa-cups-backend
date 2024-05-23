package com.piriurna.fifacups.domain.entity;

import java.util.UUID;

import com.piriurna.fifacups.domain.entity.enums.MatchStatus;
import com.piriurna.fifacups.domain.entity.interfaces.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "match_table")
@Getter
@Setter
@ToString
public class Match extends BaseEntity{
    private Integer homeScore;
    private Integer awayScore;

    @ManyToOne
    private Team homeTeam;
    @ManyToOne
    private Team awayTeam;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    public Match() {
        this.setId(UUID.randomUUID().toString());
    }

    public Match(Team homeTeam, Team awayTeam) {
        this.setId(UUID.randomUUID().toString());
        this.status = MatchStatus.FUTURE;
        this.homeScore = -1;
        this.awayScore = -1;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
}
