package com.mrglint.structure.map;

/**
 * @author luhuancheng
 * @since 2020-02-22 09:25
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    int getSize();

    boolean isEmpty();
}
