package com.mrglint.structure.map;

/**
 * @author luhuancheng
 * @since 2020-02-22 09:49
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V> root;
    private int size;

    @Override
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
        return node;
    }

    private Node<K, V> getNode(K key) {
        return getNode(root, key);
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

    @Override
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
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            return node;
        } else {
            // node.key == key, 需要对node进行删除
            if (node.left == null) {
                Node<K, V> rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node<K, V> leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node<K, V> successor = minimum(node.right);
            successor.right = removeMinimum(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = getNode(key);
        return node != null ? node.value : null;
    }

    @Override
    public void set(K key, V value) {
        Node<K, V> node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException("key " + key + "doesn't exists");
        }
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new BSTMap<>();
        map.add("A", 1);
        map.add("B", 2);
        System.out.println(map.getSize());
        map.remove("A");
        System.out.println(map.getSize());
        System.out.println(map.contains("A"));
        System.out.println(map.contains("B"));
    }
}
