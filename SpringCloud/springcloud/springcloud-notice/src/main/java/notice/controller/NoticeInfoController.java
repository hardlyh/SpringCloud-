package notice.controller;


import notice.entity.NoticeInfo;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/sendNotice")
    public Object sendNotice(@RequestBody NoticeInfo info){
        // 保存信息

        // 发送信息

        // 更新结果

        return 0;
    }
}
