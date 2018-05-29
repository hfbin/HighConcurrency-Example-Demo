package cn.hfbin.concurrency.example.threadLocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by: HuangFuBin
 * Date: 2018/5/30
 * Time: 1:13
 * Such description:
 */
@Controller
public class ThreadLocalController {

    @PostMapping("/threadlocal/test")
    public long threadlocal(){
        return RequestHolder.getId();
    }


}
