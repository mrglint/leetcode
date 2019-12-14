package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2019-12-14 21:00
 */
public class BuildTreeWithPreOrderAndInOrderSolution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     *
     * @param preorder
     * @param preorderStart
     * @param preorderEnd
     * @param inorder
     * @param inorderStart
     * @param inorderEnd
     * @return
     */
    private TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderStart]);
        // 在中序遍历结果中，寻找根节点 preorder[preorderStart], 找到之后分别构建 root 的左、右子树根节点
        for (int i = inorderStart; i < inorderEnd; i++) {
            if (preorder[preorderStart] == inorder[i]) {
                // 由于 preorder[preorderStart] == inorder[i] 因此 inorder[inorderStart, i) 属于以 preorder[preorderStart] 为根的子树的左子树节点。
                // 在前序遍历中，以 preorder[preorderStart] 为根的左子树节点位于 preorder[preorderStart + 1, preorderStart + i - inorderStart] ；i - inorderStart 左子树节点个数
                root.left = buildTree(preorder, preorderStart + 1, preorderStart + i - inorderStart, inorder, inorderStart, i - 1);
                // 在前序遍历中，以 preorder[preorderStart] 为根的右子树节点位于 preorder[preorderStart + i - inorderStart + 1, preorderEnd] i - inorderStart 左子树节点个数；
                root.right = buildTree(preorder, preorderStart + i - inorderStart + 1, preorderEnd, inorder, i + 1, inorderEnd);
            }
        }
        return root;
    }

}
