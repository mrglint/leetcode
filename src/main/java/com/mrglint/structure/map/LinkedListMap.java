package com.mrglint.structure.map;

/**
 * @author luhuancheng
 * @since 2020-02-22 09:28
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Node() {
        }
    }

    private Node<K, V> dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node<>();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node<K, V> node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node<>(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    private Node<K, V> getNode(K key) {
        Node<K, V> cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                break;
            }
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public V remove(K key) {
        Node<K, V> prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                Node<K, V> delNode = prev.next;
                prev.next = prev.next.next;
                delNode.next = null;
                size--;
                return delNode.value;
            }
            prev = prev.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = getNode(key);
        return node == null ? null : node.value;
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
}
