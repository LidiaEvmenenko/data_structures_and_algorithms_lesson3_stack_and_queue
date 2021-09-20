package ru.geekbrains.hw3;

public class HomeWorkApp {

    public static void main(String[] args) {
        MyDeque<Integer> deque = new MyDeque<>();

        deque.insertLeft(5);
        deque.insertRight(4);
        deque.insertRight(3);
        deque.insertLeft(6);
        deque.insertRight(2);
        deque.insertRight(1);
        deque.insertLeft(7);
        deque.insertLeft(8);
        deque.insertRight(0);
        deque.insertLeft(9);


        MyQueue<Integer> queue = new MyQueue<>();

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.insert(6);
        queue.insert(7);
        queue.insert(8);
        queue.insert(9);
        queue.insert(10);
        queue.insert(11);
    }

}
