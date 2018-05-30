package cn.hfbin.concurrency.example.syncContainer;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by: HuangFuBin
 * Date: 2018/5/31
 * Time: 0:54
 * Such description: 使用 Vector 时候要注意的问题
 */
@Slf4j
public class VectorExample3 {
    /*
    *  Vector 数据在更新的时候不建议使用  for-each(遍历) Iterator(迭代器)，会出现异常
    *  可以使用东西来标记等数据遍历完再进行增删操作
    *
    *  或者可以用简单的for来实现增删操作
    * */


    // Exception in thread "main" java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> v1) { // foreach
        for(Integer i : v1) {
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    // Exception in thread "main" java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> v1) { // iterator
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    // success
    private static void test3(Vector<Integer> v1) { // for
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(3)) {
                v1.remove(i);
            }
        }
        log.info("vector size : "+v1.size());
    }

    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3(vector);
    }
}

