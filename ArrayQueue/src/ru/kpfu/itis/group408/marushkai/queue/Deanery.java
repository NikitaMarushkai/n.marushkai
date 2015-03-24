package ru.kpfu.itis.group408.marushkai.queue;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Никита on 21.03.2015.
 */
public class Deanery {

    private ArrayList<String> students = new ArrayList<String>(10);
    private static Scanner sc = new Scanner(System.in);
    int i = 0;

    public Deanery(){
        int a = 10;
        while (a != 0){
            System.out.println("Enter the student");
            students.add(sc.next());
            System.out.println("continue 1/0");
            a = sc.nextInt();
        }
    }

    public String getStudent(){
        return students.get(i++);
    }

    public int getSize(){
        return students.size();
    }
}
