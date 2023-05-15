package com.emented.swing;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;

public class OutputTypeFrame extends JFrame {

    private JPanel outputTypePanel;
    private JRadioButton outputHereRadioButton;
    private JRadioButton outputToFileRadioButton;
    private JButton nextButton;
    private ButtonGroup outputTypeButtonGroup;

    public OutputTypeFrame() {
        setContentPane(outputTypePanel);
        setTitle("Output type");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nextButton.addActionListener(e -> {
            if (outputTypeButtonGroup.isSelected(outputHereRadioButton.getModel())) {
                GlobalStore.isOutputFile = false;
            } else if (outputTypeButtonGroup.isSelected(outputToFileRadioButton.getModel())) {
                GlobalStore.isOutputFile = true;
            }

            new AnswerFrame();

            dispose();
        });
    }

}
