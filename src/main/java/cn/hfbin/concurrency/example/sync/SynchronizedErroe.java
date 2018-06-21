package cn.hfbin.concurrency.example.sync;

/**
 * Created by: HuangFuBin
 * Date: 2018/6/9
 * Time: 10:56
 * Such description:
 */
public class SynchronizedErroe implements  Runnable {

     public static  Integer i = 0;

     static SynchronizedErroe s = new SynchronizedErroe();


    @Override
    public void run() {
        for (int j =0 ; j<10000 ; j++){
            synchronized (s){
                i++;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
