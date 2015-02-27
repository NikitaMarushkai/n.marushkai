package ru.kpfu.itis.group408.marushkai.polygon;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of angles");
        int n = sc.nextInt();
        double[] x = new double[n];
        double[] y = new double[n];
        System.out.println("enter the coordinates");
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
        }
        Polygon pg = new Polygon(x, y);
        if(pg.isIt()) {
            System.out.println("this polygon is convex");
        } else
            System.out.println("this polygon isn't convex");
    }
}
