package ru.kpfu.itis.group408.marushkai.mybeauty;

public class Main {
    private static final Object monitor = new Object();

    private class MyBeauty implements Runnable {

        String out;

        public MyBeauty(String out){
          this.out = out;
        }

        public void out(){
            synchronized (monitor) {
                System.out.print(out + " ");
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                synchronized (monitor) {
                    monitor.notifyAll();
                    out();

                }
            }
        }
    }


    public static void main(String[] args) {
        Main mn = new Main();
        new Thread(mn.new MyBeauty("My")).start();
        new Thread(mn.new MyBeauty("beauty")).start();
    }
}
