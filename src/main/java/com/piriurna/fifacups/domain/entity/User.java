package com.piriurna.fifacups.domain.entity;

import java.util.List;
import java.util.UUID;

import com.piriurna.fifacups.domain.entity.interfaces.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@ToString
public class User extends BaseEntity{
    @Column(unique = true)
    private String uid;

    private String nickname;
    
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Team> teams;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tournament> tournaments;

    public User() {
        this.setId(UUID.randomUUID().toString());
    }

    public User(String uid, String nickname, String email) {
        this.setId(UUID.randomUUID().toString());
        this.uid = uid;
        this.nickname = nickname;
        this.email = email;
    }
}
