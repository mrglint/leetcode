package com.mrglint.structure.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2020-02-20 22:06
 */
public class BST<E extends Comparable<E>> {

    private static class Node<E> {
        E e;
        Node<E> left, right;

        public Node(E e) {
            this.e = e;
        }
    }

    private Node<E> root;

    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node<E> add(Node<E> node, E e) {
        if (node == null) {
            size++;
            return new Node<>(e);
        }

        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node<E> node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return contains(node.left, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 前序遍历，非递归方式
     */
    public void preOrderNoRecursive() {
        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<E> pop = stack.pop();
            System.out.println(pop.e);

            if (pop.right != null) {
                stack.push(pop.right);
            }

            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    /**
     * 中序遍历, 顺序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<E> node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> queueHead = queue.poll();
            System.out.println(queueHead.e);

            if (queueHead.left != null) {
                queue.offer(queueHead.left);
            }
            if (queueHead.right != null) {
                queue.offer(queueHead.right);
            }
        }
    }

    /**
     * 寻找最小元素
     *
     * @return
     */
    public E minimum() {
        if (isEmpty()) {
            throw new IllegalStateException("BST is empty");
        }
        Node<E> minimumNode = minimum(root);
        return minimumNode.e;
    }

    private Node<E> minimum(Node<E> node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找最大元素
     *
     * @return
     */
    public E maxmum() {
        if (isEmpty()) {
            throw new IllegalStateException("BST is empty");
        }
        Node<E> maxmumNode = maxmum(root);
        return maxmumNode.e;
    }

    private Node<E> maxmum(Node<E> node) {
        if (node.right == null) {
            return node;
        }
        return maxmum(node.right);
    }

    /**
     * 删除最小元素
     * @return
     */
    public E removeMin() {
        Node<E> miniNode = minimum(root);
        root = removeMin(root);
        return miniNode.e;
    }

    private Node<E> removeMin(Node<E> node) {
        if (node.left == null) {
            // 当前node是最小节点，进行删除
            Node<E> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除最大元素
     * @return
     */
    public E removeMax() {
        Node<E> maxmumNode = maxmum(root);
        root = removeMax(root);
        return maxmumNode.e;
    }

    private Node<E> removeMax(Node<E> node) {
        if (node.right == null) {
            // 当前node是最大节点，进行删除
            Node<E> leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * Hibbard Deletion
     * 删除指定元素
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 在以node为根的树中，删除指定元素后该树的根节点
     * @param node
     * @param e
     * @return
     */
    private Node<E> remove(Node<E> node, E e) {
        // 当前节点为空，则子树为空，返回空节点
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            // 待删除元素小于当前节点，对当前节点的左子树进行节点删除后返回左子树根，挂到当前节点的左孩子节点
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            // 待删除元素大于当前节点，对当前节点的右子树进行节点删除后返回右子树根，挂到当前节点的右孩子节点
            node.right = remove(node.right, e);
            return node;
        } else {
            // 待删除元素等于当前节点，如果左子树为空，则返回当前节点的右子树作为删除后的子树根节点
            if (node.left == null) {
                Node<E> rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除元素等于当前节点，如果右子树为空，则返回当前节点的左子树作为删除后的子树根节点
            if (node.right == null) {
                Node<E> leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 当前节点等于指定元素的值，进行删除。且左右子树不为空。删除时需要维护该节点的左右子树
            // 1. 找到当前节点的后继节点（此处找右子树中最小节点）
            Node<E> successor = minimum(node.right);
            // 2. 后继节点的右子树赋值为，对原节点node的右子树进行最小元素的删除后的子树
            successor.right = removeMin(node.right);
            // 3. 后继节点的左子树赋值为，原节点node的左子树
            successor.left = node.left;
            // 4. 原节点脱离树
            node.left = node.right = null;
            // 5. 返回后继节点，作为删除后的子树根节点
            return successor;
        }
    }

    // floor ceil rank select

// add v1.0
//    public void add(E e) {
//        if (root == null) {
//            root = new Node<>(e);
//        } else {
//            add(root, e);
//        }
//    }
//    private void add(Node<E> node, E e) {
//        if (node.e.compareTo(e) == 0) {
//            return;
//        }
//        // 待添加元素小于当前节点，且左子树为空，作为当前节点的左孩子
//        if (node.e.compareTo(e) > 0 && node.left == null) {
//            node.left = new Node<>(e);
//            size++;
//        } else if (node.e.compareTo(e) < 0 && node.right == null) {
//            node.right = new Node<>(e);
//            size++;
//        }
//
//        if (node.e.compareTo(e) > 0) {
//            add(node.left, e);
//        } else {
//            add(node.right, e);
//        }
//    }
}
