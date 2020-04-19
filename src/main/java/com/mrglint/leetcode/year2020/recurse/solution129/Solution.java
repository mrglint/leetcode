package com.mrglint.leetcode.year2020.recurse.solution129;

import com.mrglint.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2020-04-19 08:17
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return 0;
        }

        sumNumbers(root, res, 0);
        return res.stream().reduce(0, (a, b) -> a + b);
    }

    private void sumNumbers(TreeNode node, List<Integer> res, int preNum) {
        preNum += node.val;
        if (node.left == null && node.right == null) {
            res.add(preNum);
            return;
        }
        if (node.left != null) {
            sumNumbers(node.left, res, preNum * 10);
        }
        if (node.right != null) {
            sumNumbers(node.right, res, preNum * 10);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        Solution solution = new Solution();
        int i = solution.sumNumbers(root);
        System.out.println(i);
    }
}
