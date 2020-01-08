package com.list;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Concurrency {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            hello();
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(runnable);
        System.out.println("main: " + Thread.currentThread().getName());
        Thread.sleep(1000);
        executorService.shutdown();
    }

    private static void hello() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("hello");
    }
}
