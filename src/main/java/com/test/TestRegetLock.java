package com.test;




import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestRegetLock {
    public static void main(String[] args) throws InterruptedException {
        Object lock=new Object();
        ReentrantLock lock2 = new ReentrantLock();
        Thread thread1=new Thread(()->{
            lock2.lock();
            synchronized (lock){
                System.out.println("第一次获取了lock1");
                synchronized (lock){
                    System.out.println("第二次获取了lock1");

                }
                new Thread(() -> {
                    synchronized (lock){
                        System.out.println("第三次获取了lock1");
                    }
                }).start();
            }
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock2.unlock();
        });
        Thread thread2 = new Thread(() -> {
            lock2.lock();
            System.out.println("第一次获取到lock2");

            new Thread(() -> {
                lock2.lock();
                System.out.println("第二次获取到lock2");
                lock2.unlock();
            }).start();

            lock2.unlock();
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

