package cn.hfbin.concurrency.example.atomic;

import cn.hfbin.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by: HuangFuBin
 * Date: 2018/5/29
 * Time: 16:55
 * Such description:
 */
@Slf4j
@ThreadSafe
public class AtomicIntegerFieldUpdaterExample1 {


    /**
     * 更新一个类的某一个字段的值，这个字段必须使用 volatile 修饰，不可以用static。
     *
     */
    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterExample1> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterExample1.class, "count");


    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {

        AtomicIntegerFieldUpdaterExample1 example5 = new AtomicIntegerFieldUpdaterExample1();

        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success one, {}", example5.getCount());
        }

        if (updater.compareAndSet(example5, 110, 120)) {
            log.info("update success two, {}", example5.getCount());
        } else {
            log.info("update failed, {}", example5.getCount());
        }
    }
}
