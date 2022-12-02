package com.nbstech.spring.basic.dataaccess;

import com.nbstech.spring.basic.dataaccess.SpringJdbcApi.PlayerDAO;
import com.nbstech.spring.basic.dataaccess.SpringJdbcApi.TournamentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDataAccessApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PlayerDAO playerDao;

	@Autowired
	TournamentDAO tournamentDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataAccessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		tournamentDAO.createTournamentTable();

		logger.info("French Players: {}", playerDao.getPlayerByNationality("France"));

		/*
		logger.info("Inserting Player 4: {}", playerDao.insertPlayer(
				new Player (4, "Thiem", "Austria", new Date(System.currentTimeMillis()), 17 ))
		);

		logger.info("Updating Player with Id 4: {}", playerDao.updatePlayer(
				new Player(4, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17))
		);

		logger.info("Deleting Player with Id 2: {}", playerDao.deletePlayerById(2));

		logger.info("All Players Data: {}", playerDao.getAllPlayers());

		logger.info("Player with Id 3: {}", playerDao.getPlayerById(3));
		 */
	}
}
