package com.nbstech.spring.basic.dataaccess.restapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
    // Some CRUD inherited from JpaRepository

    // Parse to JPQL
    public List<PlayerEntity> findByNationality(String nationality);

    @Modifying
    @Query("update PlayerEntity p set p.titles = :titles where p.id = :id")
    void updateTitles(@Param("id") int id, @Param("titles") int titles);
}
