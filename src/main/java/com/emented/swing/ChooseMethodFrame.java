package com.emented.swing;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;
import com.emented.math.LeftRectangleSolver;
import com.emented.math.MediumRectangleSolver;
import com.emented.math.RightRectangleSolver;
import com.emented.math.SimpsonSolver;
import com.emented.math.TrapezoidalSolver;

public class ChooseMethodFrame extends JFrame {
    private JPanel chooseMethodPanel;
    private JRadioButton leftRectangleMethodRadioButton;
    private JRadioButton rightRectangleMethodRadioButton;
    private JRadioButton mediumRectangleMethodRadioButton;
    private JButton nextButton;
    private JRadioButton simpsonMethodRadioButton;
    private JRadioButton trapezoidalMethodRadioButton;
    private ButtonGroup chooseMethodbuttonGroup;

    public ChooseMethodFrame() {
        setContentPane(chooseMethodPanel);
        setTitle("Method");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nextButton.addActionListener(e -> {
            if (chooseMethodbuttonGroup.isSelected(leftRectangleMethodRadioButton.getModel())) {
                GlobalStore.solver = new LeftRectangleSolver();
            } else if (chooseMethodbuttonGroup.isSelected(mediumRectangleMethodRadioButton.getModel())) {
                GlobalStore.solver = new MediumRectangleSolver();
            } else if (chooseMethodbuttonGroup.isSelected(rightRectangleMethodRadioButton.getModel())) {
                GlobalStore.solver = new RightRectangleSolver();
            } else if (chooseMethodbuttonGroup.isSelected(simpsonMethodRadioButton.getModel())) {
                GlobalStore.solver = new SimpsonSolver();
            } else if (chooseMethodbuttonGroup.isSelected(trapezoidalMethodRadioButton.getModel())) {
                GlobalStore.solver = new TrapezoidalSolver();
            }

            InputTypeFrame inputTypeFrame = new InputTypeFrame();

            inputTypeFrame.setVisible(true);
            dispose();
        });
    }
}
