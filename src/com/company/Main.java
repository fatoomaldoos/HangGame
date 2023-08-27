package com.company;
public class Main
{
    public static void main(String[] args)
    {
        Game game = new singleGame(new RandomWord());
        game.start();

       /*
        HangGame hangGame=new HangGame();
        hangGame.start();
       */

        /*
        HangMultiPlayer hangMultiPlayer=new HangMultiPlayer();
        hangMultiPlayer.start();
        */

    }
}
