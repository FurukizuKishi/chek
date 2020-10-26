package com.ck18334.methods;

public class methods {
    //Divide integers without truncation.
    public static double doubleDivision(int dividend, int divisor) {
        return (double) dividend / (double) divisor;
    }
    public static int integerDivision(int dividend, int divisor) {
        return integerDivision(dividend, divisor, 1);
    }
    public static int integerDivision(int dividend, int divisor, int multiplier) {
        return (int) (doubleDivision(dividend, divisor) * multiplier);
    }
}
