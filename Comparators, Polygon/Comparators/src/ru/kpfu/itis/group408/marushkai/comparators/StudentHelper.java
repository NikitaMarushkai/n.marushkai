package ru.kpfu.itis.group408.marushkai.comparators;

import java.util.Comparator;
/**
 * Created by unlim_000 on 24.02.2015.
 */
public class StudentHelper {

    public Comparator getGradeComparator() {
        return new Grade();
    }

    public Comparator getYearComparator() {
        return new Year();
    }

    public Comparator getNameComparator() {
        return new Name();
    }

    public static class Grade implements Comparator {

        public int compare(Object o1, Object o2) {
            if (o1 instanceof Student && o2 instanceof Student) {
                if (((Student) o1).grade > ((Student) o2).grade) {
                    return 1;
                } else if (((Student) o1).grade < ((Student) o2).grade) {
                    return -1;
                } else return 0;
            } else return -1000000;
        }

    }

    public class Year implements Comparator {
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Student && o2 instanceof Student) {
                if (((Student) o1).year > ((Student) o2).year) {
                    return 1;
                } else if (((Student) o1).year < ((Student) o2).year) {
                    return -1;
                } else return 0;
            } else return -1000000;
        }
    }

   public class Name implements Comparator {
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Student && o2 instanceof Student) {
                if (((Student) o1).name.charAt(0) > ((Student) o2).name.charAt(0)) {
                    return 1;
                } else if (((Student) o1).name.charAt(0) < ((Student) o2).name.charAt(0)) {
                    return -1;
                } else return 0;
            } else return -1000000;
        }
    }
}