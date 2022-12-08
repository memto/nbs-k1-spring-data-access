package com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Repository;

import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}