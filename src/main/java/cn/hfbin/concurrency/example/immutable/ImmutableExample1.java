package cn.hfbin.concurrency.example.immutable;

import cn.hfbin.concurrency.annoations.NotThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
/**
 * Created by: HuangFuBin
 * Date: 2018/5/30
 * Time: 0:13
 * Such description:
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        //基础数据类型是不可以被修改的
        //a = 2;
        //b = "3";

        //引用类型变量是不可以指向另外一个对象 ， 但是里面的值可以被修改 如下面
        //map = Maps.newHashMap();


        // 使用final map里面的值还是可以被修改的
        map.put(1, 3);
        log.info("{}", map.get(1));
    }

    private void test(final int a) {
        //a = 1;
    }
}
