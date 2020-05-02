package com.mrglint.leetcode.year2020.recurse.solution105;

import com.mrglint.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luhuancheng
 * @since 2020-05-02 08:33
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        // 根据根节点到中序遍历数组中，推算左子树的节点个数
        int inRootIndex = inMap.get(root.val);
        int leftNums = inRootIndex - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + leftNums, inorder, inStart, inRootIndex - 1, inMap);
        root.right = buildTree(preorder, preStart + leftNums + 1, preEnd, inorder, inRootIndex + 1, inEnd, inMap);

        return root;
    }
}
