package IteratorsAndComparatorsExercises.P03StackIterator;

import java.util.Iterator;

public class CustomStack implements Iterable<Integer> {
    private Node top;
    private int size;

    public CustomStack() {
        this.size = 0;
    }

    public void push(int number) {
        Node node = node = new Node(number, this.top);
        this.top = node;
        size++;
    }

    public int pop() {
        ensureNotEmpty();
        int element = this.top.value;
        this.top = this.top.prev;
        size--;
        return element;
    }

    public int peek() {
        ensureNotEmpty();
        return this.top.value;
    }

    private void ensureNotEmpty() {
        if (this.top == null) {
            throw new IllegalStateException("No elements");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                int element = current.value;
                current = current.prev;
                return element;
            }
        };
    }

    private static class Node {
        private int value;
        private Node prev;

        private Node(int value, Node prev) {
            this.value = value;
            this.prev = prev;
        }

    }
}