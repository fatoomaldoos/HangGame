package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player
{
    private int numberOfPlayer;
    private Player player;
    private int idPlayer;
    private String namePlayer;
    private HangGame hangGame;
    private Scanner scanner;
    private List<Player> players;
    private Game game;

    public Player(int id, String name, Game game) {
        this.idPlayer = id;
        this.namePlayer = name;
        this.game = game;
    }

    public int getId() {
        return idPlayer;
    }

    public void setId(int id) {
        this.idPlayer = id;
    }

    public String getName() {
        return namePlayer;
    }

    public void setName(String name) {
        this.namePlayer = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }


}
