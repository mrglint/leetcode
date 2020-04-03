package com.mrglint.leetcode.year2020.day30challenge.solution2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author luhuancheng
 * @since 2020-04-03 08:51
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
}
