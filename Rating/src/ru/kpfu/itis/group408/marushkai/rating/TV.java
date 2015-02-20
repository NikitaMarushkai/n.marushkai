package ru.kpfu.itis.group408.marushkai.rating;

/**
 * Created by Nikita on 17.02.2015.
 */
public class TV extends Electronic{
    int diag;

    public TV() {
        super(0, 0, 0, 0);
        this.diag = 0;
    }

    public TV (double cost, int year, double grade, double weight, int diag) {
        super.cost = cost;
        super.year = year;
        super.grade = grade;
        super.weight = weight;
        this.diag = diag;
        super.name = "TV  ";
    }

    public double getRate() {
        return super.getRate() + this.diag;
    }
}
