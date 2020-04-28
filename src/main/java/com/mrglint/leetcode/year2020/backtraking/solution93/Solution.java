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
        help(s, res, 0, 4, "");
        return res;
    }

    private void help(String s, List<String> res, int index, int remain, String current) {
        if (remain == 0) {
            if (index == s.length()) {
                res.add(current);
            }
            return;
        }

        // 最多取3位数
        for (int i = 1; i < 4; i++) {
            if (index + i > s.length()) {
                return;
            }
            // 取两位的时候，开头为0
            if (i != 1 && s.charAt(index) == '0') {
                return;
            }
            String temp = s.substring(index, index + i);
            int val = Integer.parseInt(temp);

            if (val <= 255) {
                help(s, res, index + i, remain - 1, current + temp + (remain == 1 ? "" : "."));
            }
        }
    }
}
