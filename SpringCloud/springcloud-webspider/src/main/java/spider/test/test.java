package spider.test;

import annotation.ControllerLogAnnotation;
import log.LogUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class test {

    @ControllerLogAnnotation
    @RequestMapping("/test")
    public void test(){
        LogUtil.info("1231231231231");
    }
}
