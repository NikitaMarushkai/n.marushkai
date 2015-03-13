package ru.kpfu.itis.group408.marushkai.ctv;

/**
 * Created by unlim_000 on 10.03.2015.
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
        return this.name;
    }

    public String getYear() {
        return ("" + this.year);
    }

    public String getGrade() {
        return ("" + this.grade);
    }

}
