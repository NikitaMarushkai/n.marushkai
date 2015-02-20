package ru.kpfu.itits.group408.marushkai.fastmultiply;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
        System.out.println("enter the 2 numbers");
        int x = sc.nextInt(), y = sc.nextInt();
        FastMultiply fm = new FastMultiply();
        System.out.println(fm.mult(x, y, 32));
    }
}
