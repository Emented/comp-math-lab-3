package com.emented.integral;

public class ThirdIntegral implements Integral {

    public static final String FUNCTION_NAME = "-x^3 - x^2 + x + 3";

    @Override
    public double function(double x) {
        return -Math.pow(x, 3) - x * x + x + 3;
    }

    @Override
    public double primordial(double x) {
        return 1;
    }

}
