package com.mrglint.leetcode.year2020.stack.solution94;

import com.mrglint.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2020-03-31 07:52
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        pushAllLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            pushAllLeft(cur.right, stack);
        }

        return res;
    }

    private void pushAllLeft(TreeNode node, Stack<TreeNode> stack) {
        while (Objects.nonNull(node)) {
            stack.push(node);
            node = node.left;
        }
    }
}
