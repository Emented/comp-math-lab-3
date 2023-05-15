package com.emented.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;
import com.emented.dto.Answer;
import com.emented.file.FileWorker;
import com.emented.math.AbstractSolver;


public class AnswerFrame extends JFrame {
    private JPanel answerPanel;
    private JTextArea answerArea;

    public AnswerFrame() {
        FileWorker fileWorker = new FileWorker();
        setContentPane(answerPanel);
        setTitle("Answer");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        AbstractSolver solver = GlobalStore.solver;

        Answer answer = solver.solve(GlobalStore.integral, GlobalStore.data);
        String answerString = "Answer: %f, n: %d".formatted(answer.answer(), answer.n());

        if (GlobalStore.isOutputFile) {
            fileWorker.writeAnswerToFile(answerString);
        } else {
            answerArea.setText(answerString);
            setVisible(true);
        }
    }
}
