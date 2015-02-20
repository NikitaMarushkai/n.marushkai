package ru.kpfu.itits.group408.marushkai.fastmultiply;

/**
 * Created by Nikita on 16.02.2015.
 */
public class FastMultiply {

    public int mult(int x, int y, int n) {
        int s, m1, m2, m3, a, b, c, d;
        if ((x == Math.abs(x) && y == Math.abs(y)) || (x != Math.abs(x) && y != Math.abs(y))){
            s = 1;
        } else s = -1;
        x = Math.abs(x);
        y = Math.abs(y);
        if (n == 1) {
            if (x == 1 && y == 1)
                return s;
            else
                return 0;
        } else {
            a = x >>> n/2;
            b = x & ((1 << n/2) - 1);
            c = y >>> n/2;
            d = y & ((1 << n/2) - 1);
            m1 = mult(a, c, n/2);
            m2 = mult(a-b, d-c, n/2);
            m3 = mult(b, d, n/2);
            return s*((m1 << n) + ((m1 + m2 + m3) << (n/2)) + m3);
        }
    }
}
