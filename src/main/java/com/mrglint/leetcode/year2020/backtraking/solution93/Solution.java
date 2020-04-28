package com.mrglint.leetcode.year2020.backtraking.solution93;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2020-04-28 22:10
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        int length = s.length();
        // 0, i  因此 i < 4 取出的字符串长度小于3
        for (int i = 1; i < 4 && i < length - 2; i++) {
            // i, j 因此 j < i + 4 取出的字符串长度小于3
            for (int j = i + 1; j < i + 4 && j < length - 1; j++) {
                // j, k 因此 k < j + 4 取出的字符串长度小于3
                for (int k = j + 1; k < j + 4 && k < length; k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, length);

                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        if (s.length() == 0 || s.length() > 3 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.restoreIpAddresses("25525511135");
        System.out.println(strings);
    }
}
