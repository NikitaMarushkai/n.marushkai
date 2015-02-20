package ru.kpfu.itis.group408.marushkai.rating;

/**
 * Created by Nikita on 17.02.2015.
 */
public class Computer extends Electronic {
    double proc, memory;

    public Computer(double cost, int year, double grade, double weight, double proc, double memory) {
        super(cost, year, grade, weight);
        this.proc = proc;
        this.memory = memory;
        super.name = "Computer  ";
    }

    public Computer() {
        super(0, 0, 0, 0);
        this.proc = 0;
        this.memory = 0;
    }

    public double getRate() {
        return super.getRate() + proc + memory;
    }
}