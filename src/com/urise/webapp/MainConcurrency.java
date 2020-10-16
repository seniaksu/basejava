package com.urise.webapp;

import java.util.ArrayList;
import java.util.List;

public class MainConcurrency {
    public static final int THREADS_NUMBER = 10000;
    private int counter;
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        String lock1 = "lock1";
        String lock2 = "lock2";

        printData("Thread", "");

        Thread thread0 = new Thread(() -> {
            printData("Thread", "");
            throw new IllegalStateException();
        });
        thread0.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                printData("Thread", "");
            }

            private void inc() {
                synchronized (this) {
                    // counter++;
                }
            }
        }).start();

        printData("Thread", "");

        final MainConcurrency mainConcurrency = new MainConcurrency();
        List<Thread> threads = new ArrayList<>(THREADS_NUMBER);
        for (int i = 0; i < THREADS_NUMBER; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                }
            });
            thread.start();
            threads.add(thread);
        }
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(mainConcurrency.counter);

        deadlock(lock1, lock2);
        deadlock(lock2, lock1);
    }

    private synchronized void inc() {
//      synchronized (this) {
//      synchronized (MainConcurrency.class) {
        counter++;
//      wait();
//      readFile
//        }
    }

    private static void deadlock(Object lock1, Object lock2) {
        new Thread(() -> {
            printData("Wait", lock1);
            synchronized (lock1) {
                printData("Catch", lock1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printData("Wait", lock2);
                synchronized (lock2) {
                    printData("Catch", lock2);
                }
            }
        }).start();
    }

    private static void printData(String message, Object lock) {
        System.out.println(message + " " + lock + ": "
                + Thread.currentThread().getName() + ", "
                + Thread.currentThread().getState());
    }
}