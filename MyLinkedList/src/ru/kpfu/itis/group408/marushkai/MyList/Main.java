package ru.kpfu.itis.group408.marushkai.MyList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyList<Integer> list = new MyList<Integer>();
        int a = 10;
        int c, k;
        String output;
        Scanner sc = new Scanner(System.in);
        while (a!=0) {
            System.out.println("1 - add, 2 - remove, 3 - add to index, 4 - clear list, 5 - check element, 6 - get by index, 7 - get first and last, 8 - index of element, 9 - check empty, 10 - to string," +
                    " it contains more methods, but i'm too lazy to test them here");
            a = sc.nextInt();
            switch (a){
                case 1:
                    System.out.println("what do you wanna add?");
                    c = sc.nextInt();
                    list.add(c);
                    break;
                case 2:
                    System.out.println("index of what to remove?");
                    c = sc.nextInt();
                    list.remove(c);
                    break;
                case 3:
                    System.out.println("where and what to add?");
                    c = sc.nextInt();
                    k = sc.nextInt();
                    list.add(c, k);
                    break;
                case 4:
                    list.clear();
                    break;
                case 5:
                    System.out.println("element you want to check");
                    c = sc.nextInt();
                    list.contains(c);
                    break;
                case 6:
                    System.out.println("index of what you wanna get");
                    c = sc.nextInt();
                    System.out.println(list.get(c));
                    break;
                case 7:
                    System.out.println(list.getFirst());
                    System.out.println(list.getLast());
                    break;
                case 8:
                    System.out.println("element for index");
                    k = sc.nextInt();
                    list.IndexOf(k);
                    break;
                case 9:
                    if(list.isEmpty()){
                        System.out.println("this is empty");
                    } else {
                        System.out.println("this isn't empty");
                    }
                    break;
                case 10:
                    output = list.toString();
                    System.out.println(output);
                    break;
            }
        }
    }
}
