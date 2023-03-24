package com.nbstech.spring.basic.dataaccess.restapi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
    // Some CRUD inherited from JpaRepository

    // Parse to JPQL
    public List<PlayerEntity> findByNationality(String nationality);
}
