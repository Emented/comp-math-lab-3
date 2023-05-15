package com.emented.math;

import com.emented.dto.Answer;
import com.emented.dto.InputData;
import com.emented.integral.Integral;

public class SimpsonSolver extends AbstractSolver {

    private final int k = 4;

    @Override
    public Answer solve(Integral integral, InputData data) {

        int n = super.defaultN;
        double h;
        double previous = Double.MAX_VALUE;
        double current;

        int it = 0;
        while (true) {
            it++;

            h = (data.b() - data.a()) / n;

            double[] y = new double[n + 1];
            for (int i = 0; i < n + 1; i++) {
                double currentX = data.a() + i * h;
                double currentY = integral.function(currentX);
                y[i] = currentY;
            }

            current = calculateYSum(y, n);
            current = current * h / 3;

            if (countAccuracy(previous, current, k, data.epsilon())) {
                break;
            }

            previous = current;
            n *= 2;
        }
        return new Answer(current, it);
    }

    private double calculateYSum(double[] y, int n) {
        double even = 0;
        for (int i = 1; i < y.length - 1; i += 2) {
            even += y[i];
        }
        double odd = 0;
        for (int i = 2; i < y.length - 1; i += 2) {
            odd += y[i];
        }
        return y[0] + y[n] + 4 * even + 2 * odd;
    }
}
