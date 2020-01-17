package com.mrglint.leetcode.review.recursioni;

/**
 * @author luhuancheng
 * @since 2020-01-04 09:26
 */
public class ClimbStairSolution {

    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return climbStairs(n, cache);

    }

    private int climbStairs(int n, int[] cache) {
        if (n == 1 || n == 2) {
            cache[n] = n;
            return n;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        cache[n] = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
        return cache[n];
    }
}
