package com.mrglint.structure.array;

import java.util.Arrays;

/**
 * 动态数组：
 * 1. 支持动态扩容、缩容: 空间不够则扩容到原来的2倍，当空闲空间达到3/4时，则缩容为原来的一半(避免复杂度震荡)
 * 2. 支持泛型
 * 3. 支持索引访问
 *
 * @author luhuancheng
 * @since 2020-02-17 12:15
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(E[] array) {
        data = (E[]) new Object[array.length];
        size = array.length;
    }

    public Array() {
        this(10);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("must be 0 < index <= size");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E getLast(){
        return get(size - 1);
    }

    public E removeFirst() {
        return remove(0);
    }

    public E getFirst() {
        return get(0);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("must be 0 < index < size");
        }
        E res = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && (data.length / 2) != 0) {
            resize(data.length / 2);
        }

        return res;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("must be 0 < index < size");
        }
        return data[index];
    }

    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }


    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Array[");
        res.append("capacity=").append(data.length).append(",").append("size=").append(size).append(", data=");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            } else {
                res.append("]");
            }
        }
        return res.toString();
    }

    private void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
//        E[] newData = (E[]) new Object[newCapacity];
//        for (int i = 0; i < size; i++) {
//            newData[i] = data[i];
//        }
//        data = newData;
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.addLast(10);
        System.out.println(array);
    }

    public void swap(int i, int j) {
        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }

    public void set(int index, E e) {
        data[index] = e;
    }
}
