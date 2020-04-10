package com.example.playing.card.player;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
public class PlayerService implements PlayerServiceInterface {

    /**
     * used for get the chance of first player
     * @param players list of players
     * @return player whose got first chance
     */
    public Player getFirstPlayerChance(List<Player> players) {
        Player player = new Random().nextInt(2) == 0 ? players.get(0) : players.get(1);
        return player;
    }

    /**
     * used for get player chance
     * @param players list of players
     * @return player whose got chance
     */
    public Player getPlayerChance(List<Player> players) {
        Player playerGotChance = players.stream().
                filter( (player -> player.getResult())).
                collect(Collectors.toList()).get(0);
        return playerGotChance;
    }

    /**
     * method used for return the winner
     * @param players list of players
     * @return player who win the match
     */
    public Player getWinner(List<Player> players) {



        Player winner = players.stream().
                filter( (player -> player.getResult())).
                collect(Collectors.toList()).get(0);
        return winner;

    }

    /**
     * method used for give the chance to other
     * @param players list of players
     */
    public void giveChanceToOther(List<Player> players) {

        if(players.get(0).getChance() == true ) {
            players.get(0).setChance(false);
            players.get(1).setChance(true);
        } else {
            players.get(0).setChance(true);
            players.get(1).setChance(false);
        }


    }
}
