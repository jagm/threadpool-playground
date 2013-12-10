package pl.jagm.threadpool;

import java.util.Random;

public class MyThread implements Runnable {

    private static final Random r = new Random();
    private final int id;

    public MyThread(int i) {
        id = i;
    }

    @Override
    public void run() {
        System.out.println("MyThread #" + id + " start");
        try {
            Thread.sleep(r.nextInt(5) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread #" + id + " stop");
    }
}
