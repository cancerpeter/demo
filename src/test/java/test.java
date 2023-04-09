import com.test.ClassC;
import com.test.Solution;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class test {

    @Test
    public void test01() throws InterruptedException {
//        Object c1=new Object();
//        Object c2=new Object();
//        Thread t1 = new Thread(()->{
//            synchronized (c1){
//                System.out.println("线程一启动");
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                synchronized (c2){
//                    System.out.println("线程内请求c2");
//                }
//            }
//        });
//        t1.start();
//        Thread t2 = new Thread(()->{
//            synchronized (c2){
//                System.out.println("线程二启动");
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                synchronized (c1){
//                    System.out.println("线程内请求c1");
//                }
//            }
//        });
//        t2.start();
//        t1.join();
//        t2.join();
        Solution s = new Solution();

    }


}
