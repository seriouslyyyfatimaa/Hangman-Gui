package hangman;

import java.awt.*;
import javax.swing.*;

public class WordPanel extends JPanel{
    String word;
    String guessedWord;
    JLabel wordLabel;
    
    /*
     * Constructor for WordPanel class.
     * Initializes the panel layout and the word to be guessed.
     * Creates the initial guessed word with underscores.
     * Creates and adds the word label to the panel.
     * @param word: The word to be guessed.
     */
    public WordPanel(String word) 
    {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        this.word = word;
        initializeGuessedWord();
        createWordLabel();
    }
    
    // Method to return the word.
    public String getWord() {
        return word;
    }
        
    // Method to initialize the guessed word with underscores.
    private void initializeGuessedWord() {
        guessedWord = "";
        for (int i = 0; i < word.length(); i++) 
        {
            guessedWord += "_ ";
        }
    }

    // Method to create and add the word label to the panel.
    private void createWordLabel() {
        wordLabel = new JLabel(guessedWord);
        wordLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        add(wordLabel);
    }

    /*
     * Method to guess a letter.
     * Checks if the guessed letter matches any letters in the word.
     * Updates the guessed word with the correctly guessed letters.
     * @param letter: The letter guessed by the player.
     * @return boolean: True if the guess is correct, false otherwise.
     */
    public boolean guess(String letter) {
        if (letter.length() != 1 || !Character.isLetter(letter.charAt(0))) 
        {
            return false; // Invalid guess
        }

        char guessedLetter = letter.charAt(0);
        boolean correctGuess = false;
        String newWord = "";

        for (int i = 0; i < word.length(); i++) 
        {
            if (word.charAt(i) == guessedLetter) 
            {
                newWord += guessedLetter + " ";
                correctGuess = true;
            } 
            else 
            {
                newWord += guessedWord.charAt(i * 2) + " ";
            }
        }
        guessedWord = newWord;
        wordLabel.setText(guessedWord);
        return correctGuess;
    }
    
    // Method to check if the word is completely guessed.
    public boolean wordGuessed() 
    {
        return !guessedWord.contains("_");
    }
    
    /*
     * Method to reset the word to be guessed.
     * Initializes the guessed word with underscores.
     * Updates the word label text accordingly.
     * @param word: The new word to be guessed.
     */
    public void resetWord(String word) {
        this.word = word;
        guessedWord = "";
        for (int i = 0; i < word.length(); i++) 
        {
            if (word.charAt(i) == ' ') 
            {
                guessedWord += "  ";
            } 
            else 
            {
                guessedWord += "_ ";
            }
        }
        wordLabel.setText(guessedWord);
    }
}
