package ru.kpfu.itis.group408.marushkai.comparators;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        int grade, year;
        String name;
        Student[] student = new Student[10];
        for (int i = 0; i < student.length; i++) {
            grade = rd.nextInt(100);
            year = 1970 + rd.nextInt(30);
            System.out.println("enter the name");
            name = sc.next();
            student[i] = new Student(grade, year, name);
        }
        System.out.println("Grade sorting");
        Arrays.sort(student, new StudentHelper().getGradeComparator());
        for(int i = 0; i < student.length; i++) {
            System.out.println(student[i].getName());
        }
        System.out.println("Year sorting");
        Arrays.sort(student, new StudentHelper().getYearComparator());
        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i].getName());
        }
        System.out.println("Name sorting");
        Arrays.sort(student, new StudentHelper().getNameComparator());
        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i].getName());
        }
    }
}
