package com.mrglint.leetcode.week02.solution17;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2019-10-29 07:50
 */
public class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits.length() == 0) {
            return result;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        letterCombinations(0, "", digits, result, map);
        return result;
    }

    private void letterCombinations(int level, String subResult, String digits, List<String> result, Map<Character, String> dictionary) {
        // terminate
        if (level == digits.length()) {
            result.add(subResult);
            return;
        }

        // split big problem and merge result
        char c = digits.charAt(level);
        String letter = dictionary.get(c);
        for (int j = 0; j < letter.length(); j++) {
            letterCombinations(level + 1, subResult + letter.charAt(j), digits, result, dictionary);
        }

        // restore state
    }
}
