package ru.kpfu.itis.group408.marushkai.Mm;


import java.util.Random;
import java.util.Scanner;

public class MatrixMult {

    static int[][] a;
    static int[][] b;
    static int[][] res;

    public MatrixMult(int size1, int size2, int size3) {
        Random rd = new Random();
        this.a = new int[size1][size2];
        this.b = new int[size2][size3];
        this.res = new int[size1][size3];
        System.out.println("Filling the first matrix");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = rd.nextInt(1000);
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Filling the second matrix");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = rd.nextInt(1000);
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }


    private class Multiplicator implements Runnable {

        int from, to;

        public Multiplicator(int from, int to){
            this.from = from;
            this.to = to;
        }

        private void multiply(){
            for (int i = from; i < to; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    for (int k = 0; k < b.length; k++){
                     res[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }

        @Override
        public void run() {
            this.multiply();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sizes: m, n, k, where the matrix are MxN; NxK");
        MatrixMult matrixMult = new MatrixMult(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("Enter the number of threads");
        final int threadsNumber = sc.nextInt();
        int from = 0, to = res.length / threadsNumber;
        Multiplicator[] multiplicators = new Multiplicator[threadsNumber];
        Thread thread = null;
        final long time = System.currentTimeMillis();
        for (int i = 0; i < multiplicators.length; i++) {
            multiplicators[i] = matrixMult.new Multiplicator(from, to);
            thread = new Thread(multiplicators[i]);
            thread.start();
            from = to;
            to += res.length / threadsNumber;
        }
        final long thisTime = System.currentTimeMillis() - time;
        if (thread.isAlive()) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Result matrix:");
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("The time: " + thisTime);
        }
    }
}
