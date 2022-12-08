package com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Entity;

import javax.persistence.*;

@Entity
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(cascade=CascadeType.ALL)//, optional = false)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private PlayerProfileEntity playerProfileEntity;

    public PlayerEntity( ) {

    }

    public PlayerEntity(String name) {
        super();
        this.name = name;
    }

    public PlayerEntity(String name, PlayerProfileEntity profile) {
        super();
        this.name = name;
        this.playerProfileEntity = profile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerProfileEntity getPlayerProfile() {
        return playerProfileEntity;
    }

    public void setPlayerProfile(PlayerProfileEntity playerProfileEntity) {
        this.playerProfileEntity = playerProfileEntity;
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", playerProfile=" + playerProfileEntity + "]";
    }
}
