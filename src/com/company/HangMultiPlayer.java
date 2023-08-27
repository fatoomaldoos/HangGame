package com.company;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class HangMultiPlayer extends Game
{
    private List<Player> players;
    private Scanner scanner;
    private boolean [] finishedPlayers;
    public HangMultiPlayer()
    {
        scanner = new Scanner(System.in);
        players = new ArrayList<>();
    }
    public List<Player>getPlayers()
    {
        List<Player> temp = new ArrayList<>();
        System.out.print("Enter number of players : ");
        int playersNumber = scanner.nextInt();
        for (int i = 0; i < playersNumber; i++) {
            System.out.print("Enter the name of player " + (i + 1) + " : ");
            String playerName = scanner.next();
            temp.add(new Player(i, playerName, new HangGame()));
        }
        finishedPlayers = new boolean[temp.size()];
        Arrays.fill(finishedPlayers, false);
        return temp;

    }

    private boolean isGamedFinished()
    {
        for (int i = 0; i < finishedPlayers.length; i++)
        {
            if (!finishedPlayers[i])
                return false;
        }
        return true;
    }

    @Override
    public void start()
    {
        players.addAll(getPlayers());
        while (!isGamedFinished())
        {
            for (int i=0;i<players.size();i++) {
                Player player = players.get(i);
                if (!((HangGame) player.getGame()).isGameFinished()) {
                    System.out.println(player.getName()
                            + "'s turn (" + ((HangGame) player.getGame()).getGuessedWord() + ")");
                    ((HangGame) player.getGame()).start();
                } else
                    {
                    finishedPlayers[i] = true;
                    if (isGamedFinished())
                        break;
                }
            }
    }
}
}
