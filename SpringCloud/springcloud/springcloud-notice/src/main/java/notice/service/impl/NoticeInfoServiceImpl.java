package notice.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import notice.eneity.NoticeInfo;
import notice.mapper.NoticeInfoMapper;
import notice.service.INoticeInfoService;
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
