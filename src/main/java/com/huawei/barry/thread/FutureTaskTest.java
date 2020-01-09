/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-09-30
 */
class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(new Ticket());
        new Thread(futureTask).start();
        System.out.println(Thread.currentThread().getName() + " : " + futureTask.get());

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Ticket ticket = new Ticket();
        List<Future> results = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Future<Integer> future = executorService.submit(ticket);
            // System.out.println(Thread.currentThread().getName() + " : " + future.get());
            results.add(future);
            System.out.println(executorService);
        }
        results.forEach(future -> {
            try {
                System.out.println(Thread.currentThread().getName() + " ticket bought : " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}

class Ticket implements Callable {

    private volatile Integer qty = 1000;

    @Override
    public Integer call() throws Exception {
        synchronized (qty) {
            qty = qty - 1;
            System.out.println(Thread.currentThread().getName() + " : ticket sold " + qty);
            TimeUnit.MILLISECONDS.sleep(1000);
            if (qty >= 1) {
                return qty;
            }
            return null;
        }

    }
}