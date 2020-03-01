package com.mrglint.leetcode;

/**
 * 10 ^ 0 cost 0 ms
 * 10 ^ 1 cost 0 ms
 * 10 ^ 2 cost 0 ms
 * 10 ^ 3 cost 0 ms
 * 10 ^ 4 cost 1 ms
 * 10 ^ 5 cost 2 ms
 * 10 ^ 6 cost 6 ms
 * 10 ^ 7 cost 66 ms
 * 10 ^ 8 cost 651 ms
 * 10 ^ 9 cost 6265 ms
 *
 * @author luhuancheng
 * @since 2020-03-01 12:09
 */
public class OTime {
    public static void main(String[] args) {
        for (int i = 0; i <= 9; i++) {
            double pow = Math.pow(10, i);

            int sum = 0;
            long startTime = System.currentTimeMillis();
            for (double d = 0; d < pow; d++) {
                sum += d;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("10 ^ " + i + " cost " + (endTime - startTime) + " ms");
        }
    }
}
