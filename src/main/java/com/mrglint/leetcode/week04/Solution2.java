package com.mrglint.leetcode.week04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luhuancheng
 * @since 2019-11-10 20:59
 */
public class Solution2 {
    private Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, result);
        return result;
    }
}
