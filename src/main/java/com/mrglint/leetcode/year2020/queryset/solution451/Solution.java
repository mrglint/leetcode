package com.mrglint.leetcode.year2020.queryset.solution451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 效率较低，可以借助jdk的Collections.sort 进行排序
 * @author luhuancheng
 * @since 2020-03-10 07:38
 */
public class Solution {
    public String frequencySort(String s) {
        // 统计频率
        Map<Character, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!freq.containsKey(s.charAt(i))) {
                freq.put(s.charAt(i), 0);
            }
            freq.put(s.charAt(i), freq.get(s.charAt(i)) + 1);
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(i)));
        }

        // 用数组索引作为频次
        ArrayList<Character>[] freqArray = new ArrayList[maxFreq + 1];
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (freqArray[entry.getValue()] == null) {
                freqArray[entry.getValue()] = new ArrayList<>();
            }
            freqArray[entry.getValue()].add(entry.getKey());
        }

        StringBuilder res = new StringBuilder();
        for (int i = freqArray.length - 1; i >= 0; i--) {
            if (freqArray[i] != null) {
                for (Character c : freqArray[i]) {
                    for (int j = 0; j < i; j++) {
                        res.append(c);
                    }
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String cccaaa = solution.frequencySort("cccaaa");
        System.out.println(cccaaa);
    }
}
