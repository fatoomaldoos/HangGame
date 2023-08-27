package com.company;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RandomWord extends Word
{
    private List<String>words;
    public void readWord()
    {
        words=new ArrayList<>();
        File file=new File("C:\\Users\\Fatema Aldoos\\hiddenWordInHngingGame.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty())
                    words.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String GenerateWord() {
        if (this.words == null)
            readWord();
        return this.words.get(getRandomNumber());
    }


    public int getRandomNumber()
    {
        return (int) (Math.random() * words.size());
    }
}
