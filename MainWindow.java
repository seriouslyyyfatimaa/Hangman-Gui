package hangman;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Hangman Game"); // Set the title of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the close operation.
        setSize(400, 400); // Set the size of the window.
        setLocationRelativeTo(null); // Center the window on the screen.

        // Create an instance of HealthPanel and add it to the window
        HealthPanel healthPanel = new HealthPanel(6); // Assuming 6 maximum attempts
        add(healthPanel);

        // Create an instance of WordPanel and add it to the window
        WordPanel wordPanel = new WordPanel();
        wordPanel.setWord("hangman"); // Set the word to be guessed
        add(wordPanel);
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }
}

