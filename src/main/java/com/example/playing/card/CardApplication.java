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
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

		ExecutorService executorService = Executors.newSingleThreadExecutor();


		log.info("Create the player ...........");
		List<Player> players = new ArrayList<>(2);
		players.add(new Player("amit", true, false));
		players.add(new Player("verma", true, false));

		log.info("Start the game ..........");

		CardGameService cardGameService = new CardGameService(players);
		Thread game = new Thread(cardGameService);
		executorService.submit(game);

	}

}
