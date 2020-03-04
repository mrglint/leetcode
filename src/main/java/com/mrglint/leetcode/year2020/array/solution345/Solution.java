package com.mrglint.leetcode.year2020.array.solution345;


import java.util.HashSet;
import java.util.Set;

/**
 * @author luhuancheng
 * @since 2020-03-05 07:20
 */
public class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            while (i < j && !vowels.contains(chars[i])) {
                i++;
            }
            while (i < j && !vowels.contains(chars[j])) {
                j--;
            }
            if (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.reverseVowels(".,");
        System.out.println(s);
    }
}
