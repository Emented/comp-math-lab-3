package com.emented.swing;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;
import com.emented.integral.FirstIntegral;
import com.emented.integral.SecondIntegral;
import com.emented.integral.ThirdIntegral;


public class ChooseIntegralFrame extends JFrame {
    private JPanel integralsPanel;
    private JRadioButton firstIntegralRadioButton;
    private JRadioButton secondIntegralRadioButton;
    private JRadioButton thirdIntegralRadioButton;
    private JButton nextButton;
    private JLabel chooseIntegralLabel;
    private ButtonGroup integralsButtonGroup;

    public ChooseIntegralFrame() {
        setContentPane(integralsPanel);
        setTitle("Equation");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nextButton.addActionListener(e -> {

            if (integralsButtonGroup.isSelected(firstIntegralRadioButton.getModel())) {
                GlobalStore.integral = new FirstIntegral();
            } else if (integralsButtonGroup.isSelected(secondIntegralRadioButton.getModel())) {
                GlobalStore.integral = new SecondIntegral();
            } else if (integralsButtonGroup.isSelected(thirdIntegralRadioButton.getModel())) {
                GlobalStore.integral = new ThirdIntegral();
            }

            ChooseMethodFrame chooseMethodFrame = new ChooseMethodFrame();
            chooseMethodFrame.setVisible(true);

            dispose();
        });
    }
}
