package com.mrglint.structure.trie.leetcode.solution211;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/
 * @author luhuancheng
 * @since 2020-02-23 10:34
 */
public class WordDictionary {

    private static class Node {
        boolean wordFlag;
        Map<Character, Node> next;

        Node() {
            wordFlag = false;
            next = new TreeMap<>();
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.wordFlag = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String pattern, int index) {
        if (index == pattern.length()) {
            return node.wordFlag;
        }
        char c = pattern.charAt(index);
        if (c != '.') {
            // 普通字符
            if (node.next.get(c) == null) {
                return false;
            } else {
                return match(node.next.get(c), pattern, index + 1);
            }
        }
        // 模式字符，需要比对所有节点
        for (Character nextChar : node.next.keySet()) {
            if (match(node.next.get(nextChar), pattern, index + 1)) {
                return true;
            }
        }
        return false;
    }
}
