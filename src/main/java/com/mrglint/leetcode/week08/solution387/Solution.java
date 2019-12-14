package com.mrglint.leetcode.week08.solution387;

/**
 * @author luhuancheng
 * @since 2019-12-08 22:34
 */
public class Solution {
    public int firstUniqChar(String s) {
        int[] cache = new int[256];

        for (int i = 0; i < s.length(); i++) {
            cache[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (cache[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
