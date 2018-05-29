package cn.hfbin.concurrency.example.immutable;

import cn.hfbin.concurrency.annoations.ThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;
/**
 * Created by: HuangFuBin
 * Date: 2018/5/30
 * Time: 0:23
 * Such description:
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    /**
     * 使用Collections.unmodifiableMap 也可以实现变量不可以被修改，运行后会直接报错
     */

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 3);
        log.info("{}", map.get(1));
    }

}
