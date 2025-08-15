package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGenerator {
    /*
     * Method to retrieve a random word from the text file.
     * Reads words from the file specified and stores them in an ArrayList.
     * Selects a random word from the list and returns it.
     * @return String: A random word selected from the file.
     */
    public String getRandomWord() 
    {
        ArrayList<String> words = new ArrayList<>();
        try 
        {
            File file = new File("C:/Users/zubai/git/gui_coursework/src/hangman/words.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) 
            {
                String word = scanner.nextLine();
                words.add(word);
            }
            scanner.close();
        }
        
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");
            e.printStackTrace();
        }
        
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
