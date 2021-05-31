package notice.controller;


import Log.LogUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 通知记录表 前端控制器
 * </p>
 *
 * @author Lyh
 * @since 2021-05-31
 */
@RestController
@RequestMapping("/notice")
public class NoticeInfoController {

    @RequestMapping("/test")
    public void test(){
        LogUtil.info("test");
    }
}
