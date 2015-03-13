package ru.kpfu.itis.group408.marushkai.ctv;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of students");
	    ConsoleTableViewer ctv = new ConsoleTableViewer(new MP(),new VP(), sc.nextInt());
        sc.close();
        ctv.show();
    }
}
