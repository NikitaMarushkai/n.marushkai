package ru.kpfu.itis.group408.marushkai.rating;

/**
 * Created by Nikita on 17.02.2015.
 */
public class Phone extends Electronic {

    public Phone() {
        super(0, 0, 0, 0);
    }

    public Phone (double cost, int year, double grade, double weight) {
        super.cost = cost;
        super.year = year;
        super.grade = grade;
        super.weight = weight;
        super.name = "Phone  ";
    }

    public double getRate() {
        return super.getRate();
    }

}
