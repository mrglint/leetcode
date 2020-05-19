package com.mrglint.leetcode.year2020.tag.tree.interview.solution0406;

import com.mrglint.leetcode.TreeNode;

import java.util.Objects;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2020-05-20 07:25
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();

        pushAllLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            pushAllLeft(top.right, stack);
            if (top.val == p.val) {
                return stack.isEmpty() ? null : stack.pop();
            }
        }

        return null;
    }

    private void pushAllLeft(TreeNode node, Stack<TreeNode> stack) {
        while (Objects.nonNull(node)) {
            stack.push(node);

            node = node.left;
        }
    }
}
