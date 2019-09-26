package com.huawei.barry.thread;


public class Demo5 implements Runnable {

    private static volatile int count = 0;

    private final  Object lock = new Object();


    @Override
    public void run() {

        synchronized (lock) {
            count++;
        }

    }

    public static void main(String[] args) {

        final Demo5 demo5 = new Demo5();

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(demo5);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(count);

    }
}
