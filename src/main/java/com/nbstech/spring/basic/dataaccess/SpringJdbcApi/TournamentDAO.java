package com.nbstech.spring.basic.dataaccess.SpringJdbcApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TournamentDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createTournamentTable() {
        String sql = "CREATE TABLE TOURNAMENT (ID INTEGER, NAME VARCHAR(50), LOCATION VARCHAR(50), PRIMARY KEY (ID))";
        jdbcTemplate.execute(sql);
        System.out.println("Table created");
    }
}
