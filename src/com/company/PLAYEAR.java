package com.company;
import java.util.Scanner;
public class PLAYEAR
{
    private singleGame singleGame;
    private Scanner scanner=new Scanner(System.in);

    public singleGame getSingleGame()
    {
        return singleGame;
    }
    public void win()
    {
        GameState.PlayerWin.getValue();
    }
    public void lose()
    {
             GameState.PlayerLose.getValue();
    }
    public void getNextLetter()
    {
        singleGame.setGuessed(scanner.next().charAt(0));
    }
    public void outPutResult(String result)
    {
        System.out.println(result);
    }
    public singleGame StartAnewGame()
    {
        return singleGame;
    }
    public singleGame StartAnewGame(RandomWord randomWord)
    {

        return singleGame;
    }
    public String MakeGuess(char letter)
    {
        return null;
    }

}
