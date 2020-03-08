package com.mrglint.leetcode.year2020.queryset.solution202;

import java.util.HashSet;
import java.util.Set;

/**
 * @author luhuancheng
 * @since 2020-03-08 20:35
 */
public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int sum = 0;
            while (true) {
                int mod = n % 10;
                sum = sum + mod * mod;
                n /= 10;
                if (n == 0) {
                    break;
                }
            }

            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean happy = solution.isHappy(19);
    }
}
