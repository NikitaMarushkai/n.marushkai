package ru.kpfu.itis.group408.marushkai.DynamicArray;

import java.util.Scanner;

public class Main {

    public void print(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null)
                System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main mn = new Main();
        Scanner sc = new Scanner(System.in);
        DynamicArray da = new DynamicArray(10);
        int a = 10;
        int el;
        while (a != 0) {
            System.out.println("type: 1 to add element, 2 insert element, 3 to remove element, " +
                    "4 to get element, 5 to get the size of array, 0 to stop");
            a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("element to add");
                    el = sc.nextInt();
                    da.addElement(el);
                    mn.print(da.getArr());
                    break;
                case 2:
                    System.out.println("enter the element to insert");
                    el = sc.nextInt();
                    da.insertElement(el);
                    mn.print(da.getArr());
                    break;
                case 3:
                    System.out.println("enter the element to remove");
                    el = sc.nextInt();
                    da.removeElement(el);
                    mn.print(da.getArr());
                    break;
                case 4:
                    System.out.println("enter the index of element you want to get");
                    int index = sc.nextInt();
                    System.out.println("your element is " + da.getElement(index));
                    break;
                case 5:
                    System.out.println("the size of list is " + da.getSize());
                    break;
                case 0:
                    System.out.println("the end");
                    break;
                default:
                    System.out.println("you doing it wrong...");
                    break;

            }
        }
    }
}
