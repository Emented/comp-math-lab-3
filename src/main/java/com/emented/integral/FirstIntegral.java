package com.emented.integral;

public class FirstIntegral implements Integral {

    public static final String FUNCTION_NAME  = "4x^3 - 5x^2 + 6x - 7";

    @Override
    public double function(double x) {
        return 4 * x * x * x - 5 * x * x + 6 * x - 7;
    }

    @Override
    public double primordial(double x) {
        return 1;
    }
}
