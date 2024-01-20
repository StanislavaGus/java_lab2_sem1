package org.example;

public class Main {
    public static void main(String[] args) {

        MyArrayList<String> stringList = new MyArrayList<>();

        stringList.add("One");
        stringList.add("Two");
        stringList.add("Three");

        System.out.println("Elements in stringList:");
        for (String element : stringList) {
            System.out.println(element);
        }

        System.out.println("Size of stringList: " + stringList.size());

        stringList.remove("Two");

        System.out.println("Elements in stringList after removing 'Two':");
        for (String element : stringList) {
            System.out.println(element);
        }

        MyArrayList<Integer> intList = new MyArrayList<>();

        intList.add(1);
        intList.add(3);
        intList.add(2);

        System.out.println("Elements in intList after sorting:");
        for (int element : intList) {
            System.out.println(element);
        }

        intList.clear();

        System.out.println("Size of intList after clear: " + intList.size());
    }
}