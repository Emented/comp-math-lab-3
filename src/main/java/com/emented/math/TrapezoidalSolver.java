package com.emented.math;

import java.util.Arrays;

import com.emented.dto.Answer;
import com.emented.dto.InputData;
import com.emented.integral.Integral;

public class TrapezoidalSolver extends AbstractSolver {

    private final int k = 2;
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

            current = (y[0] + y[n]) / 2 + Arrays.stream(Arrays.copyOfRange(y, 1, n - 1)).sum();
            current *= h;

            if (countAccuracy(previous, current, k, data.epsilon())) {
                break;
            }

            previous = current;
            n *= 2;
        }
        return new Answer(current, it);
    }
}
