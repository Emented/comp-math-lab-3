package com.emented.swing;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;

public class WelcomeWindow extends JFrame {

    private JLabel headerField;
    private JPanel welcomePanel;
    private JButton nextButton;

    public WelcomeWindow() {
        setContentPane(welcomePanel);
        setTitle("Laboratory work №3");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        nextButton.addActionListener(e -> {
            ChooseIntegralFrame chooseIntegralFrame = new ChooseIntegralFrame();

            chooseIntegralFrame.setVisible(true);
            dispose();
        });
    }
}
