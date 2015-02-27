package ru.kpfu.itis.group408.marushkai.polygon;

/**
 * Created by Никита on 27.02.2015.
 */
public class Polygon {
    public double[] x;
    public double[] y;

    public Polygon(double[] x, double[] y) {
        this.x = x;
        this.y = y;
    }

    private double[] getVector(double x1, double y1, double x2, double y2){
        return new double[] {x2-x1, y2-y1};
    }

    /*private double getAngle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double xa = this.getVector(x1, y1, x2, y2)[0];
        double ya = this.getVector(x1, y1, x2, y2)[1];
        double xb = this.getVector(x3, y3, x4, y4)[0];
        double yb = this.getVector(x3, y3, x4, y4)[1];
        return Math.acos(Math.abs(((xa * xb) + (ya * yb)) / (Math.sqrt(xa*xa + ya*ya) * Math.sqrt(xb*xb + yb*yb))));
    }*/

    public boolean isIt(){
        boolean is = false;
        double t = x[x.length - 1]*y[0] - x[0]*y[y.length - 1];
        double z = t / Math.abs(t);
        double p = 1;
        double r = 0;
        double k = this.getVector(x[x.length - 1], y[y.length - 1], x[0], y[0])[0] * this.getVector(x[0], y[0], x[1], y[1])[1] - this.getVector(x[0], y[0], x[1], y[1])[0] * this.getVector(x[x.length - 1], y[y.length - 1], x[0], y[0])[1];
        for (int i = 0; i < x.length - 2; i++) {
            r = this.getVector(x[i], y[i], x[i+1], y[i+1])[0] * this.getVector(x[i+1], y[i+1], x[i+2], y[i+2])[1] - this.getVector(x[i+1], y[i+1], x[i+2], y[i+2])[0] * this.getVector(x[i], y[i], x[i+1], y[i+1])[1];
            p = p*z*r/Math.abs(r);
            if (i == x.length - 3)
                p = p*z*k/Math.abs(k);

            if  (p > 0)                                               //(this.getAngle(x[i], y[i], x[i+1], y[i+1], x[i+1], y[i+1], x[i+2], y[i+2]) < 180)
                is = true;
            else
                is = false;
        }
        return is;
    }
}
