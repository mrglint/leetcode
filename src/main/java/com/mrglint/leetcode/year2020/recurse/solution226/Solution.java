package com.mrglint.leetcode.year2020.recurse.solution226;

import com.mrglint.leetcode.TreeNode;

import java.util.Objects;

/**
 * @author luhuancheng
 * @since 2020-04-11 10:57
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
