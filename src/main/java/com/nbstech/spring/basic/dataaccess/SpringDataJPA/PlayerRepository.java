package com.nbstech.spring.basic.dataaccess.SpringDataJPA;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PlayerRepository {

    @PersistenceContext
    EntityManager entityManager;

    public PlayerEntity insertPlayer(PlayerEntity player)
    {
        return entityManager.merge(player);
    }

    public PlayerEntity updatePlayer(PlayerEntity player)
    {
        return entityManager.merge(player);
    }

    public PlayerEntity getPlayerById(int id) {
        return entityManager.find(PlayerEntity.class, id);
    }

    public void deleteById(int id){
        PlayerEntity player = entityManager.find(PlayerEntity.class, id);
        entityManager.remove(player);
    }
}