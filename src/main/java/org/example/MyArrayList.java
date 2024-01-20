package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {
    private T[] array;
    private static final int def_capacity = 10;
    private static final int multiplier = 2;
    private int last_position = 0;

    public  MyArrayList(){
        this.array = (T[])  new Object[def_capacity];
    }
    public MyArrayList(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException("Capacity is wrong");
        }
        this.array = (T[]) new Object[capacity];
    }
    private void growArray(){
        long newCapacity = array.length * multiplier;
        if(newCapacity > Integer.MAX_VALUE){
            newCapacity = Integer.MAX_VALUE;
        }

        T[] newArray = (T[]) new Object[(int) newCapacity];
        System.arraycopy(this.array, 0, newArray, 0,  array.length);
        this.array = newArray;

    }

    private void checkBounds(int index) {
        if(index < 0 || index >= last_position){
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, last_position));
        }
    }
    public void add(T element) {
        if(last_position >= array.length){
            growArray();
        }
        array[last_position] = element;
        last_position++;
    }

    public void insert (int index, T element){
        if(index == last_position){
            add(element);
            return;
        }
        checkBounds(index);
        if(last_position + 1 >= array.length){
            growArray();
        }
        System.arraycopy(array, index, array, index + 1, last_position - index);
        array[index] = element;
        last_position ++;
    }

    public T set( int index, T element){
        checkBounds(index);
        T oldElement = array[index];
        array[index] = element;
        return oldElement;
    }

    public T remove(int index){
        checkBounds(index);
        T element = array[index];
        System.arraycopy(array, index + 1, array, index, last_position - index - 1);
        last_position--;
        array[last_position] = null;
        return element;
    }

    public boolean remove(T element){
        boolean result = false;

        if (element == null){
            for (int i = 0; i < last_position; i++) {
                if(array[i] == null){
                    remove(i);
                    result = true;
                    break;
                }
            }
        }else {
            for (int i = 0; i < last_position; i++) {
                if(element.equals(array[i])){
                    remove(i);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public T get(int index){
        checkBounds(index);
        return array[index];
    }

    public int size(){
        return last_position;
    }

    public void clear(){
        Arrays.fill(array, null);
        last_position = 0;
    }

    public boolean contains(T element){
        for(T item : array){
            if(item != null && item.equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < last_position;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[currentIndex++];
        }
    }

}