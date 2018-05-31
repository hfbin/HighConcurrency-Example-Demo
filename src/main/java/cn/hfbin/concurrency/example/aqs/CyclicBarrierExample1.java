package cn.hfbin.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by: HuangFuBin
 * Date: 2018/5/31
 * Time: 16:23
 * Such description: CyclicBarrier跟CountDownLatch很相似，CountDownLatch是减到零，而CyclicBarrier累加上去
 */
@Slf4j
public class CyclicBarrierExample1 {

    //多少个线程一起来同步等待
    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        executor.shutdown();
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        //告诉 CyclicBarrier，有一个线程已经ok了，会等待设置的5个线程完成了之后才会执行
        barrier.await();
        log.info("{} continue", threadNum);
    }
}
