package notice.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *
 * </p>
 *
 * @author Lyh
 * @since 2021-05-31
 */
@RestController
@RequestMapping("/notice")
public class NoticeInfoController {

    /**
     * 向钉钉发送消息
     * @return
     */
    @RequestMapping("/sendNoticeByDingDing")
    public Object sendNoticeByDingDing(){
        // 保存信息

        // 发送信息

        // 更新结果
        return 0;
    }
    
    /**
     * 向方糖发送消息(微信)
     * @return
     */
    @RequestMapping("/sendNoticeByFangTang")
    public Object sendNoticeByFangTang(){
        // 保存信息

        // 发送信息

        // 更新结果

        return 0;
    }
}
