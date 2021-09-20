package ru.geekbrains.hw3;

import java.util.Arrays;

public class MyQueue<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyQueue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue isEmpty");
        }
        return list[begin];
    }

    public void insert(T item) {
        if (isFull()) {
            reCapacity((int)(list.length*1.5));
            //throw new RuntimeException("Queue isFull");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T remove() {
        T temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private void reCapacity(int newSize){
        T[] temp = (T[]) new Object[newSize];
        if(begin < end){
            System.arraycopy(list, begin, temp, 0, size);
        }
        else {
            int firstHalf = list.length - begin;
            System.arraycopy(list, begin, temp, 0, firstHalf);
            System.arraycopy(list, 0, temp, firstHalf, size - firstHalf);
        }
        begin = 0;
        end = size;
        list = temp;
    }
}
