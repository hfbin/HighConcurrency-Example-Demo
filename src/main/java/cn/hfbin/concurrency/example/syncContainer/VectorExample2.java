package cn.hfbin.concurrency.example.syncContainer;

import cn.hfbin.concurrency.annoations.NotThreadSafe;

import java.util.Vector;

/**
 * Created by: HuangFuBin
 * Date: 2018/5/31
 * Time: 0:52
 * Such description:  Vector 在这种情况下也是存在线程安全的
 */
@NotThreadSafe
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {

        while (true) {

            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };

            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };
            thread1.start();
            thread2.start();
        }
    }
}
