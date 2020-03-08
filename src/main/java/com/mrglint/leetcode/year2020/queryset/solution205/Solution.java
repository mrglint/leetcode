package com.mrglint.leetcode.year2020.queryset.solution205;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author luhuancheng
 * @since 2020-03-09 07:22
 */
public class Solution {

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sArr = new int[256];
        int[] tArr = new int[256];
        // 初始化数组值为-1，方便之后的逻辑进行比对
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = -1;
            tArr[i] = -1;
        }

        // 遍历字符串，将字符映射为索引值
        for (int i = 0; i < s.length(); i++) {
            if (sArr[s.charAt(i)] != tArr[t.charAt(i)]) {
                return false;
            }
            sArr[s.charAt(i)] = i;
            tArr[t.charAt(i)] = i;
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!sMap.containsKey(s.charAt(i))) {
                // 当前遍历t得到的字符，已经被映射过。且与当前遍历s得到的字符不一致
                if (tMap.containsKey(t.charAt(i)) && !Objects.equals(s.charAt(i), tMap.get(t.charAt(i)))) {
                    return false;
                }
                // 字符未被映射，直接添加
                sMap.put(s.charAt(i), t.charAt(i));
                tMap.put(t.charAt(i), s.charAt(i));
            } else {
                // 字符已被映射，检查是否符合上一次的映射关系
                Character tChar = sMap.get(s.charAt(i));
                if (!Objects.equals(t.charAt(i), tChar)) {
                    return false;
                }
            }
        }
        return true;
    }
}
