package com.emented.swing;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;


public class InputTypeFrame extends JFrame {

    private JPanel inputTypePanel;
    private JRadioButton inputMyselfRadioButton;
    private JRadioButton inputFromFileRadioButton;
    private JButton nextButton;
    private ButtonGroup inputTypeButtonGroup;

    public InputTypeFrame() {
        setContentPane(inputTypePanel);
        setTitle("Input type");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nextButton.addActionListener(e -> {
            if (inputTypeButtonGroup.isSelected(inputMyselfRadioButton.getModel())) {
                GlobalStore.isInputFile = false;
                SelfInputFrame selfInputFrame = new SelfInputFrame();
                selfInputFrame.setVisible(true);

                dispose();
            } else if (inputTypeButtonGroup.isSelected(inputFromFileRadioButton.getModel())) {
                GlobalStore.isInputFile = true;
                InputFileFrame inputFileFrame = new InputFileFrame();
                inputFileFrame.setVisible(true);

                dispose();
            }
        });
    }
}
