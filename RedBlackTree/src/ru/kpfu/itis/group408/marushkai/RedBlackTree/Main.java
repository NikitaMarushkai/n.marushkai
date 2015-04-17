package ru.kpfu.itis.group408.marushkai.RedBlackTree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();
        int[] ar = new int[5];
        for (int i = 0; i < 5; i++){
            System.out.println("Введите элемент");
            int a = sc.nextInt();
            ar[i] = a;
            tree.put(a, sc.next());
        }
        for (int i = 0; i < ar.length; i++){
            System.out.println(tree.get(ar[i]));
        }
    }
}
