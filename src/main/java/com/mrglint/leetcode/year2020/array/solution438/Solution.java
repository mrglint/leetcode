package com.mrglint.leetcode.year2020.array.solution438;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2020-03-05 22:48
 */
public class Solution {
    private static final int CHARS_SET_SIZE = 26;

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }

        int[] hashP = new int[CHARS_SET_SIZE];
        for (int i = 0; i < p.length(); i++) {
            hashP[p.charAt(i) - 'a']++;
        }
        int[] hashS = new int[CHARS_SET_SIZE];

        // 滑动窗口 [lo, hi]
        int lo = 0;
        int hi = -1;

        while (hi + 1 < s.length()) {
            hi++;
            hashS[s.charAt(hi) - 'a']++;

            if (hi - lo + 1 > p.length()) {
                hashS[s.charAt(lo++) - 'a']--;
            }

            if (hi - lo + 1 == p.length() && same(hashS, hashP)) {
                result.add(lo);
            }
        }
        return result;
    }

    private boolean same(int[] hashS, int[] hashP) {
        for (int i = 0; i < CHARS_SET_SIZE; i++) {
            if (hashS[i] != hashP[i]) {
                return false;
            }
        }
        return true;
    }
}
