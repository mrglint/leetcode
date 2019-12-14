package com.mrglint.leetcode.week06.solution127;

import java.util.*;

/**
 * 双向BFS
 * @author luhuancheng
 * @since 2019-11-24 21:10
 */
public class BfsSolution {

    private static final String ALL_ALPHABETIC = "abcdefghijklmnopqrstuvwxyz";

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordLists = new HashSet<>(wordList);

        int count = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {
                String queueHead = queue.poll();
                if (Objects.equals(queueHead, endWord)) {
                    return count;
                }
                // 进行一次转换
                char[] chars = queueHead.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (Character c : ALL_ALPHABETIC.toCharArray()) {
                        char oldChar = chars[i];
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (wordLists.contains(newWord)) {
                            queue.offer(newWord);
                            wordLists.remove(newWord);
                        }
                        chars[i] = oldChar;
                    }
                }
            }
            // 每次转换长度加1
            count++;
        }
        return 0;
    }
}
