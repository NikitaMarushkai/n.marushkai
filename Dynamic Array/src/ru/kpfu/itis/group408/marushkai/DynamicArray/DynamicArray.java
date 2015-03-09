package ru.kpfu.itis.group408.marushkai.DynamicArray;

import java.util.Scanner;

/**
 * Created by Никита on 08.03.2015.
 */
public class DynamicArray {

    private Object[] arr;
    private Object[] small;
    private Object[] big;
    private int n;
    private int t = 0;
    private int downcount = 0;

    public Object[] getArr() {
        return this.arr;
    }

    public DynamicArray(int n) {
        arr = new Object[n];
        this.n = n;
    }

    private void resize(int n) {
        if (t == this.n) {
            big = new Object[n + 5];
            for (int i = 0; i < n; i++) {
                big[i] = arr[i];
            }
            arr = new Object[n + 5];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = big[i];
            }
            this.n = n + 5;
        }
    }

    private void downsize(int n) {
        if (downcount == 5) {
            small = new Object[n - 5];
            for (int i = 0; i < n - 5; i++) {
                small[i] = arr[i];
            }
            arr = new Object[n - 5];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = small[i];
            }
            this.n = n - 5;
            downcount = 0;
        }
    }

    public void addElement(Object o) {
        this.resize(n);
        arr[t] = o;
        t++;
    }

    public void insertElement(Object o) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the place");
        int place = sc.nextInt();
        arr[place] = o;
    }

    public void removeElement(Object o) {
        this.downsize(n);
        int ind = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == o) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
            }
        }
        downcount++;
    }

    public Object getElement(int index) {
        return arr[index];
    }

    public int getSize() {
        return arr.length;
    }


}
