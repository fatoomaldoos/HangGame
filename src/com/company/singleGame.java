package com.company;
import java.util.Arrays;
import java.util.Scanner;
public class singleGame extends Game
{
    private String hiddenWord;
    private boolean[]revealed;
    private GameState state;
    private int score;
    private RandomWord randomWord;
    private Scanner scanner;
    private String guessedWord;
    private int errorsNumber;
    private char guessed;
    private Rules rules;
    public singleGame()
    {
    }
    public singleGame(RandomWord randomWord)
    {
        scanner=new Scanner(System.in);
        this.hiddenWord = randomWord.GenerateWord();
        this.guessedWord=this.initializeGuessedWord();
        this.errorsNumber=0;
        rules=new Rules();
    }
    public char getGuessed() {
        return guessed;
    }
    @Override
    public void start()
    {
        System.out.println(hiddenWord);
        System.out.println(GameState.NewGame.getValue());
        while (!isGameFinished()) {
            startGuess();
        }
        result();
    }

    public String initializeGuessedWord()
    {
        char[] temp = new char[hiddenWord.length()];
        Arrays.fill(temp, '*');
        return new String(temp);
    }
    public boolean[] initializeRevealedArray()
    {
       revealed= new boolean[hiddenWord.length()];
        Arrays.fill(revealed,false);
        return revealed;
    }
    public boolean isCharExist(char guessed)
    {
        return hiddenWord.indexOf(guessed) != -1;
    }
    public GameState AcceptGuess(char letter)
    {
        if (hiddenWord.indexOf(letter)!=-1)
            return GameState.PlayerWin;
        else
            return GameState.PlayerLose;
    }
    public String ReplaceCharacter(String string, int index, char newChar)
    {
        return string.substring(0,index)+newChar+string.substring(index+1);
    }
    public void FixWordAfterGuess(char guessed)
    {
        int index=hiddenWord.indexOf(guessed);
        hiddenWord=ReplaceCharacter(hiddenWord,index,'*');
        guessedWord=ReplaceCharacter(guessedWord,index,guessed);
    }
    public boolean isGameFinished()
    {
        return errorsNumber ==hiddenWord.length()  || !guessedWord.contains("*");
    }
    public void result()
    {
        if(this.errorsNumber == hiddenWord.length())
        {
            System.out.println(GameState.PlayerLose.getValue());
        }
        else
            System.out.println(GameState.PlayerWin.getValue());
    }
    public void setHiddenWord(String hiddenWord)
    {
        this.hiddenWord = hiddenWord;
    }
    public void setRevealed(boolean[] revealed)
    {
        this.revealed = revealed;
    }
    public void setState(GameState state) {
        this.state = state;
    }
    public void setScore(int score)
    {
        this.score = score;
    }
    public void setRandomWord(RandomWord randomWord) {
        this.randomWord = randomWord;
    }
    public String getHiddenWord() {
        return hiddenWord;
    }
    public boolean[] getRevealed() {
        return revealed;
    }

    public GameState getState() {
        return state;
    }

    public int getScore() {
        return score;
    }

    public void setGuessed(char guessed) {
        this.guessed = guessed;
    }

    public RandomWord getRandomWord() {
        return randomWord;
    }
    public void startGuess()
    {
        System.out.println(guessedWord);
        System.out.print("Enter a char : ");
         guessed = scanner.next().charAt(0);
        rules.arbiter(guessed);
        /*if (isGameFinished())
            result();*/
    }

    class Rules
    {
        void arbiter(char guessedChar) {
            if (isCharExist(guessedChar))
            {
                FixWordAfterGuess(guessedChar);
                System.out.println("Good!!");
                System.out.println("the word became: " + guessedWord);
            } else
                {
                errorsNumber++;
                System.out.println(guessedWord+"\n"+"sorry,Char isn't exist!!");
            }
        }


    }
}
