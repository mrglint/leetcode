package com.mrglint.structure.set;

/**
 * @author luhuancheng
 * @since 2020-02-22 08:13
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    boolean isEmpty();

    int getSize();
}
