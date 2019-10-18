package com.mrglint.leetcode.solution70;

/**
 * @author luhuancheng
 * @since 2019-10-17 09:11
 */
public class Solution {

    // f(n) = f(n - 1) + f(n - 2)
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int twoStepBefore = 1;
        int oneStepBefore = 2;
        int all = 0;
        for (int i = 2; i < n; i++) {
            all = twoStepBefore + oneStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = all;
        }
        return all;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i<10; i++) {
            System.out.print(solution.climbStairs(i));
            System.out.print(", ");
        }
    }

}
