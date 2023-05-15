package com.emented.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;
import com.emented.dto.InputData;


public class SelfInputFrame extends JFrame {
    private JButton nextButton;
    private JPanel selfInputPanel;
    private JTextField bField;
    private JTextField aField;
    private JTextField eField;
    private JLabel errorLabel;

    public SelfInputFrame() {
        setContentPane(selfInputPanel);
        setTitle("Input type of interval");
        setSize(900, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nextButton.addActionListener(e -> {
            double a;
            double b;
            double epsilon;
            try {
                String aText = aField.getText();
                String bText = bField.getText();
                String epsilonText = eField.getText();

                if (aText.isBlank()) {
                    errorLabel.setText("A interval must not be empty");
                    return;
                }

                if (bText.isBlank()) {
                    errorLabel.setText("B interval must not be empty");
                    return;
                }

                if (epsilonText.isBlank()) {
                    errorLabel.setText("Epsilon must not be empty");
                    return;
                }

                a = Double.parseDouble(aText.replaceAll(",", "."));
                b = Double.parseDouble(bText.replaceAll(",", "."));
                epsilon = Double.parseDouble(epsilonText.replaceAll(",", "."));

                if (a > 100 || a < -100) {
                    errorLabel.setText("A must be a floating point number between -100 and 100");
                    return;
                }

                if (b > 100 || b < -100) {
                    errorLabel.setText("B must be a floating point number between -100 and 100");
                    return;
                }

                if (a <= b) {
                    errorLabel.setText("A boarder must be greater then B");
                    return;
                }

                if (epsilon <= 0 || epsilon >= 1) {
                    errorLabel.setText("Epsilon must be a floating point number between 0 and 1");
                    return;
                }

                GlobalStore.data = new InputData(a, b, epsilon);

                OutputTypeFrame outputTypeFrame = new OutputTypeFrame();

                outputTypeFrame.setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                errorLabel.setText("A, B and epsilon must be floating point numbers");
            }
        });
    }
}
