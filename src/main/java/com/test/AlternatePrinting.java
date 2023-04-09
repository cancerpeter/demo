package com.test;

public class AlternatePrinting {

    private int count = 1;
    private Object lock = new Object();

    public static void main(String[] args) {
        AlternatePrinting ap = new AlternatePrinting();
        Thread thread1 = new Thread(ap.new Printer(1));
        Thread thread2 = new Thread(ap.new Printer(2));
        thread1.start();
        thread2.start();
    }

    class Printer implements Runnable {

        private int flag;

        public Printer(int flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
//            while (count <= 8) {
//                synchronized (lock) {
//                    if (count % 2 == flag - 1) {
//                        System.out.println(Thread.currentThread().getName() + ":" + count++);
//                        lock.notifyAll();
//                    } else {
//                        try {
//                            lock.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
            synchronized (lock){
                while(count <= 8){
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

