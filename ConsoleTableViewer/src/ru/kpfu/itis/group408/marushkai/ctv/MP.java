package ru.kpfu.itis.group408.marushkai.ctv;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by unlim_000 on 10.03.2015.
 */
public class MP implements ModelProvider<Student> {

    public Comparator<Student> getComparator(){
        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.grade > o2.grade)
                    return 1;
                else if (o1.grade < o2.grade)
                    return -1;
                else
                    return 0;
            }
        };
    }

    public String randomName(){
        Random rd = new Random();
        String[] names = {"Nikita", "Anastasia", "Ilyas", "Vladislav", "Maksim",
        "Anvar", "Ilgiz", "Aleksander", "Azat", "Ilyas", "Aleksander", "Alina",
        "Timur", "Mikhail", "Ildar", "Ilya", "Lenar", "Kamila", "Timur", "Novfal",
        "Fazil", "Vadim", "Diana", "Margo"};
        return names[rd.nextInt(names.length-1)];

    }

    public Student[] getElements(int n){
        Student[] st = new Student[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            st[i] = new Student(rd.nextInt(100), 1970 + rd.nextInt(30), this.randomName());
        }
        return st;
    }
}
