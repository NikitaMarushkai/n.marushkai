package ru.kpfu.itis.group408.marushkai.stack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BracketAnalyzer ba = new BracketAnalyzer(new ArrayStack<Character>());
        System.out.println("enter the string to check");
        if (ba.check(sc.next())){
            System.out.println("Brackets are OK");
        } else {
            System.out.println("incorrect input, brackets problem");
        }
    }
}
