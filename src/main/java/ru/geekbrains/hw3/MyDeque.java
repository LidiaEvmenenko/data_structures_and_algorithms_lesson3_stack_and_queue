package ru.geekbrains.hw3;

import java.util.Arrays;

public class MyDeque<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 5;
    private int begin;
    private int end;

    public MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyDeque() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int previousIndex(int index) {
        if(index > 0)
            return index - 1;
        return list.length - 1;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue isEmpty");
        }
        return list[begin];
    }

    public T peekBack() {
        if (isEmpty()) {
            throw new RuntimeException("Queue isEmpty");
        }
        return list[previousIndex(end)];
    }

    public void insertRight(T item) {
        if (isFull()) {
            reCapacity((int)(list.length*1.5));
            //throw new RuntimeException("Queue isFull");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertLeft(T item) {
        if (isFull()) {
            reCapacity((int)(list.length*1.5));
            //throw new RuntimeException("Queue isFull");
        }
        size++;
        begin = previousIndex(begin);
        list[begin] = item;
    }

    public T removeLeft() {
        T temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeRight() {
        T temp = peekBack();
        size--;
        end = previousIndex(end);
        list[end] = null;
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
