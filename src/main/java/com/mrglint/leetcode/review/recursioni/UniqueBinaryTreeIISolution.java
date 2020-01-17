package com.mrglint.leetcode.review.recursioni;

import com.mrglint.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个数字，生成一棵拥有指定数字节点个数的搜索树，包含元素范围[1, n].
 *
 * @author luhuancheng
 * @since 2020-01-07 07:37
 */
public class UniqueBinaryTreeIISolution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int min, int max) {
        // terminator
        List<TreeNode> list = new ArrayList<>();
        if (min > max) {
            list.add(null);
            return list;
        }

        // process current level
        for (int idx = min; idx <= max; idx++) {
            // 生成所有可以以idx作为根的所有左节点
            List<TreeNode> leftNodes = generateTrees(min, idx - 1);
            // 生成所有可以以idx作为根的所有右节点
            List<TreeNode> rightNodes = generateTrees(idx + 1, max);

            // 拼接可以有多少种可能
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(idx);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
