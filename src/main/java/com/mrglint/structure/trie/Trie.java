package com.mrglint.structure.trie;


import java.util.Map;
import java.util.TreeMap;

/**
 * 前缀树
 *
 * @author luhuancheng
 * @since 2020-02-23 08:32
 */
public class Trie {

    private static class Node {
        boolean wordFlag;
        Map<Character, Node> next;

        Node(boolean wordFlag) {
            this.wordFlag = wordFlag;
            next = new TreeMap<>();
        }

        public Node() {
            this.wordFlag = false;
            next = new TreeMap<>();
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.wordFlag) {
            cur.wordFlag = true;
            size++;
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.wordFlag;
    }

    public boolean prefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    public boolean patternMatch(String pattern) {
        return match(root, pattern, 0);
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
