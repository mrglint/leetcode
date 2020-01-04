package com.mrglint.leetcode.review.recursion;

/**
 * @author luhuancheng
 * @since 2020-01-04 07:55
 */
public class FibNumberSolution {

    public int fib(int n) {
        int[] cache = new int[n + 1];
        return fib(n, cache);
    }
    public int fib(int n, int[] cache) {
        if (n <= 1) {
            return n;
        }

        if (cache[n] != 0) {
            return cache[n];
        }
        cache[n] = fib(n - 1) + fib(n - 2);
        return cache[n];
    }
}
