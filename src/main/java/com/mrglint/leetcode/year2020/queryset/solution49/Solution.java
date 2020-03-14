package com.mrglint.leetcode.year2020.queryset.solution49;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2020-03-14 21:49
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] hash = new int[26];
            for (int i = 0; i < s.length(); i++) {
                hash[s.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(hash);
            List<String> list = map.getOrDefault(key, new LinkedList<>());
            list.add(s);
            map.put(key, list);
        }
        return new LinkedList<>(map.values());
    }
}
