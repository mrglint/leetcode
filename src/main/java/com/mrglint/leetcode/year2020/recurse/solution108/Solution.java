package com.mrglint.leetcode.year2020.recurse.solution108;

import com.mrglint.leetcode.TreeNode;

/**
 * 二分法
 * 通过二分法将节点分摊到根节点两边，因此节点数之差不大于1；以此继续递归即可
 *
 * @author luhuancheng
 * @since 2020-04-24 07:27
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (hi < lo) {
            return null;
        }

        // 中间位置的数 > 数组左边数列
        // 中间位置的数 < 数组右边数列
        int mid = lo + ((hi - lo) >> 1);
        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortedArrayToBST(nums, lo, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, hi);
        return node;
    }
}
