package com.mrglint.leetcode.week02.solution50;

/**
 * @author luhuancheng
 * @since 2019-10-28 07:19
 */
public class Solution {

    /**
     * 暴力解法
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    /**
     * 利用分支的思想
     * 基于这有一个思考：x ^ n = x ^ (n / 2) * x ^ (n / 2)
     * 将大问题的解题过程，拆解为求子问题 x ^ (n / 2)，之后合并子问题结果
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return fastPow(x, n);
    }
    private double fastPow(double x, int i) {
        // terminator
        if (i == 0) {
            return 1;
        }
        // split big problem
        // int halfI = i / 2;

        // drill down
        double half = fastPow(x, i / 2);

        // merge sub result
        if (i % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
