package com.mrglint.leetcode.year2020.queue.solution127;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * @author luhuancheng
 * @since 2020-04-06 18:55
 */
public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String s = queue.poll();
                if (Objects.equals(s, endWord)) {
                    return res + 1;
                }
                // 变换字符串
                for (int i = 0; i < s.length(); i++) {
                    char[] chars = s.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        char oldChar = chars[i];
                        if (oldChar != j) {
                            chars[i] = j;
                            String temp = new String(chars);
                            if (wordSet.contains(temp)) {
                                wordSet.remove(temp);
                                queue.offer(temp);
                            }
                        }
                        chars[i] = oldChar;
                    }
                }
            }
            res++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(i);
    }
}
