package com.example.playing.card;

import com.example.playing.card.card.module.Card;
import com.example.playing.card.card.service.CardService;
import com.example.playing.card.game.CardGameService;
import com.example.playing.card.player.Player;
import com.example.playing.card.player.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class CardApplication {

	/**
	 * start the main application
	 * create the two player
	 * create the CardGameService and start game
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CardApplication.class, args);


		log.info("Create the player ...........");
		List<Player> players = new ArrayList<>(2);
		players.add(new Player("amit", true, false));
		players.add(new Player("verma", true, false));


		log.info("Start the game ..........");
		CardGameService cardGameService = new CardGameService();
		cardGameService.startGame(players);

		log.info("Declare the winner ..................");
		PlayerService playerService = new PlayerService();
		Player player = playerService.getWinner(players);
		log.info("Winner {}", player.getPlayerName());





	}

}
