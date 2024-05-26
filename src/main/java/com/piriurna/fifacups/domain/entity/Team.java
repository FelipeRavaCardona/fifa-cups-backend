package com.piriurna.fifacups.domain.entity;

import java.util.List;
import java.util.UUID;

import com.piriurna.fifacups.domain.entity.interfaces.BaseEntity;

import jakarta.persistence.Entity;
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
public class Team extends BaseEntity {
    private String name;
    private String imageUrl;

    @ManyToOne
    private User owner;
    
    @ManyToMany(mappedBy = "assignedTeams")
    private List<Tournament> tournaments;

    @OneToMany(mappedBy = "team")
    private List<GroupTeamInfo> groups;

    @ManyToMany
    private List<Tournament> entryRequests;

    public Team() {
        this.setId(UUID.randomUUID().toString());
    }

    public Team(String name, String imageUrl, User owner) {
        this.setId(UUID.randomUUID().toString());
        this.name = name;
        this.imageUrl = imageUrl;
        this.owner = owner;
    }
}
