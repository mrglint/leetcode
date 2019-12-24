package com.mrglint.leetcode.review.queue;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2019-12-14 09:07
 */
public class Solution {

    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int res = 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String queueHead = queue.poll();
                if (Objects.equals(queueHead, endWord)) {
                    // 长度包含起始单词
                    return res + 1;
                }
                // 变换字符
                char[] queueHeadCharArray = queueHead.toCharArray();
                for (char c : ALPHABET) {
                    for (int i = 0; i < queueHeadCharArray.length; i++) {
                        char temp = queueHeadCharArray[i];
                        queueHeadCharArray[i] = c;
                        String newWord = new String(queueHeadCharArray);
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                        queueHeadCharArray[i] = temp;
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
