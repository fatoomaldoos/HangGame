package com.company;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class HangGame extends Game
{
    private String hiddenWord;
    private String guessedWord;
    private Scanner scanner;
    private int errorsNumber;
    private char guessed;
    private ArrayList<Integer>index;
    HangGame()
    {
        scanner = new Scanner(System.in);
        hiddenWord = new RandomWord().GenerateWord();
        guessedWord = generateGuessedWord();
        errorsNumber=0;
        index=new ArrayList<>();

    }
    public String generateGuessedWord()
    {
        char[] temp = new char[hiddenWord.length()];
        Arrays.fill(temp, '*');
        return new String(temp);
    }
    public void setHiddenWord(String string)
    {
        this.hiddenWord=string;
    }
    public void setGuessedWord(String string)
    {
        this.guessedWord=string;
    }
    public String getHiddenWord() {
        return hiddenWord;
    }
    public boolean isCharExist(char guessed)
    {
        return hiddenWord.indexOf(guessed) != -1;
    }
    public char[] changeToCharArray(String s)
    {
        String str=s;
        char[]charArray=s.toCharArray();
        return charArray;
    }
      public boolean isStringContainsHid(String s)

    {
        return s.contains("*");
    }
    public boolean isGameFinished()
    {
        if(this.errorsNumber == hiddenWord.length() && !guessedWord.contains("*"))
            return true;
        return false;
    }
    public String ReplaceCharacter(String string, int index, char newChar)
    {
        return string.substring(0,index)+newChar+string.substring(index+1);
    }

    public int getIndex(char[]c,char a)
    {
        for (int i=0;i<c.length;i++)
            if (c[i]==a)
                return i;
            return 0;
    }
    public String replaceChar(char[]from,char[]to)
    {
        char[] tempHidden = from;
        char[] tempGueesd = to;
        for (int i = 0; i < tempHidden.length; i++) {
            if (tempHidden[i] == this.guessed)
                tempGueesd[i] = this.guessed;
        }
        return String.valueOf(tempGueesd);
    }
    public void play()
    {
        this.guessed=scanner.next().charAt(0);
        if (isCharExist(this.guessed))
        {
            int index=hiddenWord.indexOf(this.guessed);
            this.hiddenWord=this.ReplaceCharacter(hiddenWord,index,'*');
            this.guessedWord=this.ReplaceCharacter(guessedWord,index,guessed);
            System.out.println(guessedWord);
        }
        else {
            errorsNumber++;
            System.out.println(this.guessedWord);
        }
        if (isGameFinished())
            this.finalResult();
    }
    @Override
    public void start()
    {
               System.out.println(this.getGuessedWord());
        while (!isGameFinished())
            play();
    }

    public void finalResult()
    {
        // play();
        if (isWin())
            System.out.println("_______CONGRATULATIONS!!_______");
        else
        {
            System.out.println("_______GAME OVER !!_______");
         //   System.out.println("the hidden word was:"+this.hiddenWord);
        }
    }

    public int getErrorsNumber()
    {
        return errorsNumber;
    }

    public String getGuessedWord() {
        return guessedWord;
    }

    public boolean isWin()
    {
        return (!guessedWord.contains("*"));
    }


}
