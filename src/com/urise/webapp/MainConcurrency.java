package com.urise.webapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainConcurrency {
    public static final int THREADS_NUMBER = 10000;
    private int counter;
    private final AtomicInteger atomicCounter = new AtomicInteger();
    // private static final Object LOCK = new Object();
    //private static final Lock lock = new ReentrantLock();
    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static final Lock WRITE_LOCK = reentrantReadWriteLock.writeLock();
    private static final Lock READ_LOCK = reentrantReadWriteLock.readLock();

    private static final ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() ->
            new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"));

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
        CountDownLatch latch = new CountDownLatch(THREADS_NUMBER);
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        //    CompletionService completionService = new ExecutorCompletionService(executorService);
        //     List<Thread> threads = new ArrayList<>(THREADS_NUMBER);
        for (int i = 0; i < THREADS_NUMBER; i++) {
            Future<Integer> future = executorService.submit(() ->
                    //  Thread thread = new Thread(() ->
            {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                    System.out.println(threadLocal.get().format(new Date()));
                }
                latch.countDown();
                return 5;
            });

            // completionService.poll();
            // System.out.println(future.isDone());
            // System.out.println(future.get());
            // thread.start();
            // threads.add(thread);
        }
/*
            threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
 */
        latch.await(10, TimeUnit.SECONDS);
        executorService.shutdown();
        // System.out.println(mainConcurrency.counter);
        System.out.println(mainConcurrency.atomicCounter.get());

        deadlock(lock1, lock2);
        deadlock(lock2, lock1);
    }

    //   private synchronized void inc() {
    private void inc() {
//      synchronized (this) {
//      synchronized (MainConcurrency.class) {
        atomicCounter.incrementAndGet();
/*        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }*/
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