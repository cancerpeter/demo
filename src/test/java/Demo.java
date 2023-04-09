import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) {
        Object obj = new Object();
        Thread thread1 = new Thread(new PrintNum(obj, true), "thread1");
        Thread thread2 = new Thread(new PrintNum(obj, false), "thread2");
        //Thread thread3 = new Thread(new PrintNum(obj, false), "thread3");

        thread2.start();
        //thread3.start();
        thread1.start();
    }
}

class PrintNum implements Runnable{
    private static int num;
    private Object obj;
    private boolean isFirstThread;
    public PrintNum(Object obj, boolean isFirstThread) {
        num = 0;
        this.obj = obj;
        this.isFirstThread = isFirstThread;
    }
    @Override
    public void run() {
        synchronized (obj) {
            while (true) {
                // 第一次进来可以直接打印，但是第二次进来后要等到被被唤醒才能打印
                if (isFirstThread) {
                    isFirstThread = false;
                } else {
                    try {
                        obj.wait();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + num++);

                // 通知其他线程
                obj.notifyAll();
            }
        }
    }
}
