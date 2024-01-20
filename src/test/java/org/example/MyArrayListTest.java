package org.example;

import static org.junit.Assert.*;

public class MyArrayListTest {

    @org.junit.Test
    public void add() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals("One", list.get(0));
        assertEquals("Two", list.get(1));
        assertEquals("Three", list.get(2));
        assertEquals(3, list.size());
    }

    @org.junit.Test
    public void insert() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Three");

        list.insert(1, "Two");

        assertEquals("One", list.get(0));
        assertEquals("Two", list.get(1));
        assertEquals("Three", list.get(2));
        assertEquals(3, list.size());
    }

    @org.junit.Test
    public void set() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");

        String oldElement = list.set(1, "NewTwo");

        assertEquals("One", list.get(0));
        assertEquals("NewTwo", list.get(1));
        assertEquals("Two", oldElement);
        assertEquals(2, list.size());


    }

    @org.junit.Test
    public void remove() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        String removedElement = list.remove(1);

        assertEquals("One", list.get(0));
        assertEquals("Three", list.get(1));
        assertEquals("Two", removedElement);
        assertEquals(2, list.size());


    }

    @org.junit.Test
    public void testRemove() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        boolean result = list.remove("Two");

        assertTrue(result);
        assertEquals("One", list.get(0));
        assertEquals("Three", list.get(1));
        assertEquals(2, list.size());
    }

    @org.junit.Test
    public void get() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals("Two", list.get(1));
    }

    @org.junit.Test
    public void size() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");

        assertEquals(2, list.size());
    }

    @org.junit.Test
    public void clear() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");

        list.clear();

        assertEquals(0, list.size());
        assertFalse(list.contains("One"));
        assertFalse(list.contains("Two"));
    }
    @org.junit.Test
    public void contains() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertTrue(list.contains("Two"));
        assertFalse(list.contains("Four"));
    }
}