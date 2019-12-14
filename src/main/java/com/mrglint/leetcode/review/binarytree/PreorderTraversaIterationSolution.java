package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-12-11 07:45
 */
public class PreorderTraversaIterationSolution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode stackTop = stack.pop();
            if (stackTop != null) {
                res.add(stackTop.val);
                stack.push(stackTop.right);
                stack.push(stackTop.left);
            }
        }
        return res;
    }
}
