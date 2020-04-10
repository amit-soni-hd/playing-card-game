package com.example.playing.card.player;

import java.util.List;

public interface PlayerServiceInterface {

    Player getFirstPlayerChance(List<Player> players);

    Player getPlayerChance(List<Player> players);

    Player getWinner(List<Player> players);

    public void giveChanceToOther(List<Player> players);
}
