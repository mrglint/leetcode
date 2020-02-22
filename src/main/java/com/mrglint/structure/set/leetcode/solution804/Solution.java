package com.mrglint.structure.set.leetcode.solution804;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/unique-morse-code-words/submissions/
 *
 * @author luhuancheng
 * @since 2020-02-22 10:56
 */
public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(morseCodes[word.charAt(i) - 'a']);
            }
            set.add(res.toString());
        }
        return set.size();
    }
}
