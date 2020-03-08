package com.mrglint.leetcode.year2020.array.solution3;

/**
 * @author luhuancheng
 * @since 2020-03-05 08:10
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // ASCII码共256个
        int[] hash = new int[256];

        // 滑动窗口 [lo, hi] 中不包含重复字符
        int lo = 0;
        int hi = -1;

        int result = 0;

        while (lo < s.length()) {
            if (hi + 1 < s.length() && hash[s.charAt(hi + 1)] == 0) {
                hash[s.charAt(hi + 1)]++;
                hi++;
            } else {
                hash[s.charAt(lo)]--;
                lo++;
            }

            result = Math.max(result, hi - lo + 1);
        }
        return result;
    }
}
