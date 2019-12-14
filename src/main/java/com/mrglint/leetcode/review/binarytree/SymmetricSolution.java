package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

import java.util.Stack;

/**
 * 对称树
 *
 * @author luhuancheng
 * @since 2019-12-12 08:17
 */
public class SymmetricSolution {

    public boolean isSymmetricIterationSolution(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    public boolean isSymmetricRecursiveSolution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricRecursiveSolution(root.left, root.right);
    }
    private boolean isSymmetricRecursiveSolution(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val
                && isSymmetricRecursiveSolution(left.left, right.right)
                && isSymmetricRecursiveSolution(left.right, right.left);
    }
}
