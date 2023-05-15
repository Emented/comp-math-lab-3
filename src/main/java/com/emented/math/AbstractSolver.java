package com.emented.math;

import com.emented.dto.Answer;
import com.emented.dto.InputData;
import com.emented.integral.Integral;

public abstract class AbstractSolver {

    protected final int defaultN = 4;

    public abstract Answer solve(Integral integral, InputData data);

    protected boolean countAccuracy(double I0, double I1, int k, double epsilon) {
        return (Math.abs((I0 - I1)) / (Math.pow(2, k) - 1)) <= epsilon;
    }
}
