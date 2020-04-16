package com.mrglint.leetcode.year2020.recurse.solution257;

import com.mrglint.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2020-04-17 07:16
 */
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        binaryTreePaths(root, res, "");
        return res;
    }

    private void binaryTreePaths(TreeNode node, List<String> res, String path) {
        // 叶子节点
        if (node.left == null && node.right == null) {
            res.add(path + node.val);
        }
        if (node.left != null) {
            binaryTreePaths(node.left, res, path + node.val + "->");
        }
        if (node.right != null) {
            binaryTreePaths(node.right, res, path + node.val + "->");
        }
    }
}
