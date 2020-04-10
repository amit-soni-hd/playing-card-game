package com.example.playing.card.player;

public class Player {

    private String playerName;
    private Boolean result;
    private Boolean chance;

    public Player(String playerName, Boolean result, Boolean chance) {
        this.playerName = playerName;
        this.result = result;
        this.chance = chance;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Boolean getChance() {
        return chance;
    }

    public void setChance(Boolean chance) {
        this.chance = chance;
    }
}
