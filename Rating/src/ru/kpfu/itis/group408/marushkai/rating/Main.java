package ru.kpfu.itis.group408.marushkai.rating;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rd = new Random();
        int r = 0;
        double cost, grade, weight, proc, memory;
        int year, diag;
        Electronic[] a = new Electronic[10];
        for (int i = 0; i < a.length; i++) {
            r = rd.nextInt(3);
            if (r == 0) {
                cost = 500 + rd.nextInt(50000);
                grade = rd.nextInt(5);
                weight = 300 + rd.nextInt(800);
                year = 2009 + rd.nextInt(6);
                a[i] = new Phone(cost, year, grade, weight);
            } else if (r == 1) {
                cost = 10000 + rd.nextInt(500000);
                grade = rd.nextInt(5);
                weight = 1 + rd.nextInt(50000);
                year = 2009 + rd.nextInt(6);
                diag = 20 + rd.nextInt(80);
                a[i] = new TV(cost, year, grade, weight, diag);
            } else if (r == 2) {
                cost = 10000 + rd.nextInt(50000);
                grade = rd.nextInt(5);
                weight = 1 + rd.nextInt(5000);
                year = 2009 + rd.nextInt(6);
                proc = 1 + rd.nextInt(4);
                memory = 1000 + rd.nextInt(7000);
                a[i] = new Computer(cost, year, grade, weight, proc, memory);
            }
        }
        Arrays.sort(a);
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i].toString());
        }
    }
}
