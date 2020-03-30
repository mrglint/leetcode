package com.mrglint.leetcode.year2020.stack.solution144;

import com.mrglint.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2020-03-31 07:47
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (Objects.nonNull(top)) {
                res.add(top.val);

                if (Objects.nonNull(top.right)) {
                    stack.push(top.right);
                }
                if (Objects.nonNull(top.left)) {
                    stack.push(top.left);
                }
            }
        }

        return res;
    }
}
