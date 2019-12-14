package com.mrglint.algorithm.dp;

/**
 * @author luhuancheng
 * @since 2019-12-02 21:13
 */
public class Fib {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        // 0, 1, 1, 2, 3, 5
        int prev = 0;
        int cur = 1;
        // n = 2时，只需一次循环。定义 i 从0开始，那么 i < 1,即 i < n - 1
        for (int i = 0; i < n - 1; i++) {
            int sum = prev + cur;
            prev = cur;
            cur = sum;
        }
        return cur;
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        for (int i = 0; i < 8; i++) {
            System.out.println(fib.fib(i));
        }
    }
}
