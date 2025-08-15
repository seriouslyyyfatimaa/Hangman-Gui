package hangman;

import javax.swing.*;
import java.awt.*;

public class HealthPanel extends JPanel {

    private int maxAttempts;
    private int currentAttempts;
    private JLabel[] attemptLabels;

    public HealthPanel(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.currentAttempts = 0;
        this.attemptLabels = new JLabel[maxAttempts];
        setLayout(new FlowLayout());

        // Create and add the attempt labels to the panel
        for (int i = 0; i < maxAttempts; i++) {
            attemptLabels[i] = new JLabel();
            attemptLabels[i].setOpaque(true);
            attemptLabels[i].setBackground(Color.GREEN);
            attemptLabels[i].setPreferredSize(new Dimension(20, 20));
            add(attemptLabels[i]);
        }
    }

    // Remove an attempt and update the health display
    public boolean removeLife() {
        if (currentAttempts < maxAttempts) {
            attemptLabels[currentAttempts].setBackground(Color.RED);
            currentAttempts++;
        }

        return currentAttempts >= maxAttempts;
    }
}
