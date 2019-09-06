package com.huawei.barry.thread;

public class Demo4 {

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 is starting...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 ended");
    }

    public void m2() {
        System.out.println(Thread.currentThread().getName() + " m2 is starting...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ended");
    }

    public static void main(String args[]) {
        final Demo4 demo4 = new Demo4();

        new Thread(() -> {
            demo4.m1();

        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo4.m2();
            }
        });
    }

}
