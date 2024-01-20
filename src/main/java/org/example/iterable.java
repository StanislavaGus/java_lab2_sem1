package org.example;

import java.util.Comparator;
import java.util.Iterator;

public interface iterable<T> {
    void add(T element);
    void insert (int index, T element);
    T set( int index, T element);
    T remove(int index);
    boolean remove(T element);
    T get(int index);
    int size();
    void clear();
    boolean contains(T element);

    Iterator<T> iterator();
}