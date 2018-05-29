package cn.hfbin.concurrency.example.atomic;

import cn.hfbin.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by: HuangFuBin
 * Date: 2018/5/29
 * Time: 16:55
 * Such description:
 */
@Slf4j
@ThreadSafe
public class AtomicReferenceExample {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0, 2); // 2
        log.info("count:{}", count.get());
        count.compareAndSet(0, 1); // no
        log.info("count:{}", count.get());
        count.compareAndSet(1, 3); // no
        log.info("count:{}", count.get());
        count.compareAndSet(2, 4); // 4
        log.info("count:{}", count.get());
        count.compareAndSet(3, 5); // no
        log.info("count:{}", count.get());
        count.compareAndSet(5, 6); // no
        log.info("count:{}", count.get());
        count.compareAndSet(4, 7); // 7
        log.info("count:{}", count.get());
        count.compareAndSet(6, 8); // no
        log.info("count:{}", count.get());
        count.compareAndSet(7, 10); // 8
        log.info("count:{}", count.get());
        count.compareAndSet(9, 13); // no
        log.info("count:{}", count.get());
        count.compareAndSet(11, 13); // no
        log.info("count:{}", count.get());
        count.compareAndSet(12, 13); // no
        log.info("count:{}", count.get());
        count.compareAndSet(10, 13); // 13
        log.info("count:{}", count.get());
    }
}
