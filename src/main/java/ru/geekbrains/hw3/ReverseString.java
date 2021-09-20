package ru.geekbrains.hw3;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str;
        System.out.println("Введите строку: ");
        str=scanner.next();
        System.out.println(str);
        System.out.print("Результат разворота строки: " + reverse(str));
    }

    public static StringBuilder reverse(String exp) {
        MyStack<Character> stack = new MyStack<>(exp.length());
        char ch;
        for (int i = 0; i < exp.length(); i++) {
            ch = exp.charAt(i);
            stack.push(ch);
        }
        StringBuilder reverseStr = new StringBuilder(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            reverseStr.append(stack.pop());
        }
        return reverseStr;
    }

}
