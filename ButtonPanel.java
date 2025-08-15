package hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
    private JButton[] buttons;
    private WordPanel wordPanel;
    private HealthDisplayPanel healthPanel;
    private HangmanMainWindow main;
    
    /*
     * Constructor for ButtonInterface class.
     * Initializes the button interface with letter buttons from A to Z.
     * Adds action listeners to each button to handle user interaction.
     * @param wordPanel: The WordPanel instance for processing player's guesses.
     */
    public ButtonPanel(WordPanel wordPanel,HealthDisplayPanel healthPanel,HangmanMainWindow main) {
    	this.healthPanel=healthPanel;
        this.wordPanel = wordPanel;
        this.main = main;
        buttons = new JButton[26];
        
        for (int i = 0; i < 26; i++) {
            char letter = (char) ('A' + i);
            buttons[i] = new JButton(String.valueOf(letter));
            
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();
                    clickedButton.setEnabled(false);
                    String guessedLetter = clickedButton.getText();
                    boolean isOutofHP = false;
                    if (!wordPanel.guess(guessedLetter)) {
                    	isOutofHP = healthPanel.deductLife();
                    }
                    if(isOutofHP) {
                    	main.endGame(false, wordPanel.getWord());
                    }
                    else if(wordPanel.wordGuessed()) {
                    	main.endGame(true, wordPanel.getWord());
                    }
                }
            });
            
            add(buttons[i]);
        }
    }

    /*
     * Method to reset the letter buttons.
     * Enables all buttons to be clickable again.
     */
    public void resetButtons() {
        for (JButton button : buttons) {
            button.setEnabled(true);
        }
    }
}
