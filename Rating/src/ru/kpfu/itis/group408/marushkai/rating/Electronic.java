package ru.kpfu.itis.group408.marushkai.rating;

/**
 * Created by Nikita on 17.02.2015.
 */
public class Electronic implements Comparable {
    double cost;
    int year;
    double grade;
    double weight;
    String name;
    Electronic() {
        this(0, 0, 0, 0);
    }

    Electronic(double cost, int year, double grade, double weight) {
        this.cost = cost;
        this.year = year;
        this.grade = grade;
        this.weight = weight;
    }

    public double getRate() {
        return 1000000/cost + 100*year + 50*grade + 100/weight;
    }

    public int compareTo(Object o) {
        if (o instanceof Electronic) {
            if (this.getRate() > ((Electronic) o).getRate()) {
                return 1;
            } else if (this.getRate() < ((Electronic) o).getRate()) {
                return -1;
            } else {
                return 0;
            }
        } else return 100;
    }

        public String toString() {
            return name +  " " + getRate();
        }

}
