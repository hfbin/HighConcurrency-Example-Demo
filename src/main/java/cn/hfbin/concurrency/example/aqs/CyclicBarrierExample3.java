package cn.hfbin.concurrency.example.aqs;

import cn.hfbin.concurrency.annoations.NotRecommend;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by: HuangFuBin
 * Date: 2018/5/31
 * Time: 16:23
 * Such description:
 */
@Slf4j
public class CyclicBarrierExample3 {

    //CyclicBarrier 可以指定Runnable， Runnable：当线程达到屏障的时候，线程优先执行这个Runnable ， 即执行完了设置的5个线程后就会执行这个Runnable
    private static CyclicBarrier barrier = new CyclicBarrier(5, () -> {
        log.info("callback is running");
    });

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
        barrier.await();
        log.info("{} continue", threadNum);
    }
}
