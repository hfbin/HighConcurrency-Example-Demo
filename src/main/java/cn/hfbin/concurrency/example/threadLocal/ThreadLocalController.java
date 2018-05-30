package cn.hfbin.concurrency.example.threadLocal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by: HuangFuBin
 * Date: 2018/5/30
 * Time: 1:13
 * Such description:
 */
@Controller
@Slf4j
public class ThreadLocalController {

    @RequestMapping("/threadLocal/test")
    @ResponseBody
    public String threadlocal(){
        log.info(RequestHolder.getId()+"");
        return RequestHolder.getId()+"";
    }


}
