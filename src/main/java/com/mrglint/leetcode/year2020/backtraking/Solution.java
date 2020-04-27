package com.mrglint.leetcode.year2020.backtraking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luhuancheng
 * @since 2020-04-27 07:51
 */
public class Solution {

    private static final Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        letterCombinations(0, "", digits, res);
        return res;
    }

    private void letterCombinations(int level, String subRes, String digits, List<String> res) {
        if (level == digits.length()) {
            res.add(subRes);
            return;
        }

        char c = digits.charAt(level);
        String s = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            letterCombinations(level + 1, subRes + s.charAt(i), digits, res);
        }
    }
}
