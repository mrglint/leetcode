package com.mrglint.structure.stack;

/**
 * @author luhuancheng
 * @since 2020-02-18 08:15
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
