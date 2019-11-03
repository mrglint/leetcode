package com.mrglint.leetcode.week03.solution69;

/**
 * @author luhuancheng
 * @since 2019-10-30 21:13
 */
public class Solution {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long left = 1;
        long right = x;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(8));
    }
}
