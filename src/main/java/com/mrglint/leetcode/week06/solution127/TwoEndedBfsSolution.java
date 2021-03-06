package com.mrglint.leetcode.week06.solution127;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 双向BFS
 * @author luhuancheng
 * @since 2019-11-24 21:36
 */
public class TwoEndedBfsSolution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // HashSet提供O(1)时间复杂度的查询
        Set<String> words = new HashSet<>(wordList);
        // 记录访问过的单词，转换路径中每个单词只能使用一次
        Set<String> visited = new HashSet<>();

        // 长度包含第一个单词
        int count = 1;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            // 交换一下遍历方向
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> tempSet = new HashSet<>();

            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char oldChar = chars[i];
                        chars[i] = c;
                        String newWord = String.valueOf(chars);
                        // 两个遍历方向重叠
                        if (endSet.contains(newWord)) {
                            return count + 1;
                        }
                        if (!visited.contains(newWord) && words.contains(newWord)) {
                            tempSet.add(newWord);
                            visited.add(newWord);
                        }
                        chars[i] = oldChar;
                    }
                }
            }
            count++;
            beginSet = tempSet;
        }
        return 0;
    }
}
