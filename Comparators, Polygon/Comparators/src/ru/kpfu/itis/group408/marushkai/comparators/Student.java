package ru.kpfu.itis.group408.marushkai.comparators;


/**
 * Created by Никита on 24.02.2015.
 */
public class Student {
    int grade;
    int year;
    String name;

    public Student(int grade, int year, String name) {
        this.grade = grade;
        this.year = year;
        this.name = name;
    }

    public String getName() {
        return (this.name + " " + this.year + " " + this.grade);
    }

}
