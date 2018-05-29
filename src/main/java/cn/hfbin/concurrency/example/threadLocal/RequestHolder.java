package cn.hfbin.concurrency.example.threadLocal;

/**
 * Created by: HuangFuBin
 * Date: 2018/5/30
 * Time: 1:13
 * Such description:
 */
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
