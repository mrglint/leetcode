package com.mrglint.leetcode.year2020.queryset.solution290;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author luhuancheng
 * @since 2020-03-08 21:09
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }

        Map<Character, String> charToString = new HashMap<>();
        Map<String, Character> stringToChar = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            if (!charToString.containsKey(pattern.charAt(i))) {
                // 字符串已经被其他字符映射过
                if (stringToChar.containsKey(strs[i]) && !Objects.equals(stringToChar.get(strs[i]), pattern.charAt(i))) {
                    return false;
                }
                charToString.put(pattern.charAt(i), strs[i]);
                stringToChar.put(strs[i], pattern.charAt(i));
            } else {
                String matchString = charToString.get(pattern.charAt(i));
                if (!Objects.equals(strs[i], matchString)) {
                    return false;
                }
            }
        }
        return true;
    }
}
