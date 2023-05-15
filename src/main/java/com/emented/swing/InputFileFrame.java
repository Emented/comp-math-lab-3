package com.emented.swing;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;
import com.emented.file.FileWorker;


public class InputFileFrame extends JFrame {
    private JButton fileButton;
    private JPanel filePanel;
    private JLabel errorLabel;
    private JButton nextButton;


    public InputFileFrame() {
        setContentPane(filePanel);
        setTitle("File");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        fileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();

            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                FileWorker fileWorker = new FileWorker();
                try {
                    GlobalStore.data = fileWorker.readInputData(file);

                    fileButton.setText(file.getName());

                    nextButton.addActionListener(e1 -> {
                        OutputTypeFrame outputTypeFrame = new OutputTypeFrame();

                        outputTypeFrame.setVisible(true);
                        dispose();
                    });
                } catch (Exception ex) {
                    errorLabel.setText(ex.getMessage());
                }

            }
        });

    }
}
