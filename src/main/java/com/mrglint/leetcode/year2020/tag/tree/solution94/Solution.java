package com.mrglint.leetcode.year2020.tag.tree.solution94;

import com.mrglint.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2020-05-11 07:23
 */
public class Solution {

    /**
     * 迭代实现中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        pushAllLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            result.add(top.val);
            pushAllLeft(top.right, stack);
        }

        return result;
    }

    private void pushAllLeft(TreeNode node, Stack<TreeNode> stack) {
        while (Objects.nonNull(node)) {
            stack.push(node);
            node = node.left;
        }
    }
}
