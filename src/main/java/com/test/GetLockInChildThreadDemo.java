package com.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:  heatdeath
 * Date:    2018/7/15
 * Desc:
 */
public class GetLockInChildThreadDemo {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
//        lock.lock();
//        try {
//            System.out.println(Thread.currentThread() + " i got the lock");
//            new Thread(() -> {
//                lock.lock();
//                try {
//                    System.out.println(Thread.currentThread() + " I got the lock and going to sleep");
//                    Thread.sleep(5000);
//                    System.out.println(Thread.currentThread() + " I am waked up");
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                } finally {
//                    lock.unlock();
//                }
//            }).start();
//            Thread.sleep(6000);
//            System.out.println(Thread.currentThread() + " I am waked up");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            lock.unlock();
//        }
        synchronized (GetLockInChildThreadDemo.class) {
            try {
                System.out.println(Thread.currentThread() + " i got the lock");

                new Thread(() -> {
                    synchronized (GetLockInChildThreadDemo.class) {
                        try {
                            System.out.println(Thread.currentThread() + " I got the lock and going to sleep");
                            Thread.sleep(5000);
                            System.out.println(Thread.currentThread() + " I am waked up");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }).start();

                Thread.sleep(6000);
                System.out.println(Thread.currentThread() + " I am waked up");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
