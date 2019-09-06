package com.huawei.barry.thread;

public class Demo2 {


        public static void main(String[] args) {
            //创建一个窗口
            TicketWindow2 tw1=new TicketWindow2();
            //使用三个线程同时启动
            Thread t1=new Thread(tw1);
            Thread t2=new Thread(tw1);
            Thread t3=new Thread(tw1);
            t1.start();
            t2.start();
            t3.start();
        }
    }
    //售票窗口类
    class TicketWindow2 implements Runnable{
        private int nums=2000;       //一共2000张票
        public void test() {
            int test;
            boolean me;
            while(true){
                test=nums--;
                synchronized (this) {
                    me=test>0;
                }
                if(me){        //先判断是否还有票
                    //Thread.currentThread().getName()得到当前线程的名字
                    System.out.println(Thread.currentThread().getName()+"在售出第"+test+"张票"); //显示售票信息
                    //出票的速度是一秒出一张
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;       //售票结束
                }
            }
        }
        @Override
        public void run() {
            test();
        }
    }
