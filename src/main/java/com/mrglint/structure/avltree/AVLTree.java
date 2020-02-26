package com.mrglint.structure.avltree;

import java.util.ArrayList;
import java.util.List;

/**
 * 难点：
 * 1. 什么时候需要维护平衡？ 平衡因子绝对值大于1时，需要维护平衡。
 * 2. 当某个node打破平衡了，该怎么维护平衡？不同插入形态决定了需要如何旋转来维护平衡；左旋、右旋、先左旋再右旋、先右旋再左旋
 *
 * @author luhuancheng
 * @since 2020-02-23 18:10
 */
public class AVLTree<K extends Comparable<K>, V> {

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left, right;
        int height;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
            height = 1;
        }
    }

    private Node<K, V> root;
    private int size;

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node<K, V> add(Node<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new Node<>(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            // key已存在，更新value
            node.value = value;
        }

        // 更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            System.out.println("打破平衡二叉树定义 " + balanceFactor);
        }

        // 平衡维护. https://coding.imooc.com/learn/questiondetail/146084.html
        // LL 新插入节点，被插入到node的左节点的左子树中
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            // 右旋转
            return rightRotate(node);
        }

        // RR 新插入节点，被插入到node的右节点的右子树中
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            // 左旋转
            return leftRotate(node);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            // 左旋转后右旋转
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            // 右旋转后左旋转
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node<K, V> rightRotate(Node<K, V> y) {
        Node<K, V> x = y.left;
        Node<K, V> T3 = x.right;

        // 向右旋转过程
        x.right = y;
        y.left = T3;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node<K, V> leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        // 向左旋转过程
        x.left = y;
        y.right = T2;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }


    private int getBalanceFactor(Node node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private Node<K, V> getNode(K key) {
        return getNode(root, key);
    }

    public boolean isBST() {
        List<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isBalance() {
        return isBalance(root);
    }

    private boolean isBalance(Node<K, V> node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }

        return isBalance(node.left) && isBalance(node.right);
    }

    private void inOrder(Node<K, V> node, List<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    private Node<K, V> getNode(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    public V remove(K key) {
        Node<K, V> node = getNode(key);

        if (node != null) {
            root = remove(root, key);
            return node.value;
        } else {
            return null;
        }
    }

    private Node<K, V> minimum(Node<K, V> node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private Node<K, V> removeMinimum(Node<K, V> node) {
        if (node.left == null) {
            Node<K, V> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        return removeMinimum(node.left);
    }

    private Node<K, V> remove(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        Node<K, V> retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            // node.key == key, 需要对node进行删除
            if (node.left == null) {
                Node<K, V> rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                Node<K, V> leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                Node<K, V> successor = minimum(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                retNode = successor;
            }
        }

        if (retNode == null) {
            return null;
        }



        return retNode;
    }

    public boolean contains(K key) {
        return getNode(key) != null;
    }

    public V get(K key) {
        Node<K, V> node = getNode(key);
        return node != null ? node.value : null;
    }

    public void set(K key, V value) {
        Node<K, V> node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException("key " + key + "doesn't exists");
        }
        node.value = value;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }
}
