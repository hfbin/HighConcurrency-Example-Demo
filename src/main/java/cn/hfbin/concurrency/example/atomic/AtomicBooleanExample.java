package cn.hfbin.concurrency.example.atomic;

import cn.hfbin.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by: HuangFuBin
 * Date: 2018/5/29
 * Time: 16:55
 * Such description:让某一段代码只执行一遍，使用AtomicBoolean完成此功能
 */
@Slf4j
@ThreadSafe
public class AtomicBooleanExample {

    private static AtomicBoolean isHappened = new AtomicBoolean(false);
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("isHappened:{}", isHappened.get());
    }

    private static void test() {
        //compareAndSet(true, false)   一次也不会执行
        //compareAndSet(false, true)    只执行一次
        //compareAndSet(true, true)     一次也不会执行
        //compareAndSet(false, false)   执行完 5000 次
        //无论怎么设置isHappened.get() 最后的值都为false
        if (isHappened.compareAndSet(true, false)) {
            log.info("execute");
        }
    }

}
