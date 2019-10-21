package com.mrglint.leetcode.solution70;

/**
 * @author luhuancheng
 * @since 2019-10-17 09:11
 */
public class Solution {

    /**
     * 加缓存的递归调用
     */
    public int climbStairs1(int n) {
        int[] memory = new int[n];
        return climbStairs1(n, memory);
    }
    private int climbStairs1(int i, int[] memory) {
        if (i == 1) {
            memory[i - 1] = 1;
            return 1;
        }
        if (i == 2) {
            memory[i - 1] = 2;
            return 2;
        }
        if (memory[i - 1] > 0) {
            return memory[i - 1];
        }
        memory[i - 1] = climbStairs1(i - 1, memory) + climbStairs1(i - 2, memory);
        return memory[i - 1];
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
            System.out.print(solution.climbStairs1(i));
            System.out.print(", ");
        }
    }

}
