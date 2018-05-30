package cn.hfbin.concurrency.example.threadLocal;

import cn.hfbin.concurrency.annoations.ThreadSafe;

/**
 * Created by: HuangFuBin
 * Date: 2018/5/30
 * Time: 1:13
 * Such description: 可以在web应用中使用
 *  比如我们在一个请求连接中需要做一些处理，需要通过request中获取某些信息，
 *  在某个方法需要传request才能获取到对应的信息，
 *  这个时候解决这种繁琐的传参问题，就可以用ThreadLocal解决了
 *  我们可以在拦截器里面，将有需要保存到request的数据放到ThreadLocal中即可，然后请求完了就在Interceptor中移除即可
 *
 */
@ThreadSafe
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
