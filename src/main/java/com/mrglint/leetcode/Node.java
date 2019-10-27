package com.mrglint.leetcode;

import java.util.List;

/**
 * @author luhuancheng
 * @since 2019-10-26 07:40
 */
public class Node {
    public int val;

    public List<Node> children;

    public Node() {
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
