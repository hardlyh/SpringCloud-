package notice.notice_info.service.impl;

import notice.notice_info.entity.NoticeInfo;
import notice.notice_info.mapper.NoticeInfoMapper;
import notice.notice_info.service.INoticeInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知记录表 服务实现类
 * </p>
 *
 * @author Lyh
 * @since 2021-05-24
 */
@Service
public class NoticeInfoServiceImpl extends ServiceImpl<NoticeInfoMapper, NoticeInfo> implements INoticeInfoService {

}
