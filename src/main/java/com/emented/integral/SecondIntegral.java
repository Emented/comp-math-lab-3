package com.emented.integral;

public class SecondIntegral implements Integral {

    public static final String FUNCTION_NAME = "sin(2x)^2 / 7";

    @Override
    public double function(double x) {
        return Math.pow(Math.sin(2 * x), 2) / 7;
    }

    @Override
    public double primordial(double x) {
        return 1;
    }

}
