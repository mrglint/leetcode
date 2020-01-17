package com.mrglint.leetcode.review.recursioni;

/**
 * @author luhuancheng
 * @since 2020-01-04 09:48
 */
public class PowSolution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
