package com.huawei.barry.thread;

public class Demo3 {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Test is ruuing, current ticket left is :");
            }
        });


    }
}


class Test implements Runnable {

    private int num = 100;
    @Override
    public void run() {
        num--;
        System.out.println("Test is ruuing, current ticket left is :" + num);
    }
}