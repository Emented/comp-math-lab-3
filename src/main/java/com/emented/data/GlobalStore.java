package com.emented.data;


import com.emented.dto.InputData;
import com.emented.integral.Integral;
import com.emented.math.AbstractSolver;


public class GlobalStore {
    public static InputData data;

    public static Integral integral;
    public static AbstractSolver solver;
    public static boolean isInputFile;
    public static boolean isOutputFile;
}
