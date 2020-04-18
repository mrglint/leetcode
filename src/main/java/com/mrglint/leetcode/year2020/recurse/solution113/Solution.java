package com.mrglint.leetcode.year2020.recurse.solution113;

import com.mrglint.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2020-04-18 07:48
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> subRes = new ArrayList<>();
        pathSum(root, res, subRes, sum);

        return res;
    }

    private void pathSum(TreeNode node, List<List<Integer>> res, List<Integer> subRes, int sum) {
        subRes.add(node.val);
        if (sum == node.val && node.left == null && node.right == null) {
            res.add(new ArrayList<>(subRes));
            // 回溯前，恢复原有数据
            subRes.remove(subRes.size() - 1);
            return;
        }
        if (node.left != null) {
            pathSum(node.left, res, subRes, sum - node.val);
        }
        if (node.right != null) {
            pathSum(node.right, res, subRes, sum - node.val);
        }
        subRes.remove(subRes.size() - 1);
    }

}
