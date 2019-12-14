package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2019-12-13 07:55
 */
public class BuildTreeWithInOrderAndPostOrderSolution {

    int pInorder;   // index of inorder array
    int pPostorder; // index of postorder array

    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
        // create root node
        // 1. 构建根节点
        TreeNode n = new TreeNode(postorder[pPostorder--]);

        // if right node exist, create right subtree
        // 右子树还没到底
        if (inorder[pInorder] != n.val) {
            n.right = buildTree(inorder, postorder, n);
        }

        // 中序索引后退1
        pInorder--;

        // if left node exist, create left subtree
        // 1. 如果end.val == inorder[pInorder] 说明没有左孩子
        if ((end == null) || (inorder[pInorder] != end.val)) {
            n.left = buildTree(inorder, postorder, end);
        }

        return n;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (pPostorder < 0) {
            return null;
        }

        pInorder = inorder.length - 1;
        pPostorder = postorder.length - 1;

        return buildTree(inorder, postorder, null);
    }

    public static void main(String[] args) {
        BuildTreeWithInOrderAndPostOrderSolution solution = new BuildTreeWithInOrderAndPostOrderSolution();
        solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

}
