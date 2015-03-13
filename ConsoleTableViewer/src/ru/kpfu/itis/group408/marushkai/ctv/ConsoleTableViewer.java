package ru.kpfu.itis.group408.marushkai.ctv;

import java.util.Arrays;

/**
 * Created by unlim_000 on 10.03.2015.
 */
public class ConsoleTableViewer  {
    public ModelProvider<Student> model;
    public ViewProvider<Student> view;
    int height;
    Student[] students;

    public ConsoleTableViewer(ModelProvider<Student> model, ViewProvider<Student> view, int height) {
        this.model = model;
        this.view = view;
        this.height = height;
        students = new Student[model.getElements(this.height).length];
        students = model.getElements(this.height);
        Arrays.sort(students, model.getComparator());
    }

    public void show(){
        for (int i = 0; i < view.getColumnCount(); i++) {
            System.out.printf("%10s", view.getHeader()[i]);
        }
        System.out.println();
        for (int i = 0; i < students.length; i++) {
            System.out.printf("%10s", "Student" + " " + i);
            System.out.printf("%10s", view.getLabel(students[i], 1));
            System.out.printf("%10s", view.getLabel(students[i], 3));
            System.out.printf("%10s", view.getLabel(students[i], 2));
            System.out.println();
        }
    }
}
