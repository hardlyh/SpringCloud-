package notice.controller;


import Log.LogUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/sendNotice")
    public Object sendNotice(@RequestBody JSONObject js){
        String result = js.getString("123");
        LogUtil.info(result);
        return 0;
    }
}
