package dbi.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import dbi.eneity.NoticeInfo;
import dbi.mapper.NoticeInfoMapper;
import dbi.service.INoticeInfoService;

/**
 * <p>
 * 通知记录表 服务实现类
 * </p>
 *
 * @author Lyh
 * @since 2021-05-31
 */
@Service
public class NoticeInfoServiceImpl extends ServiceImpl<NoticeInfoMapper, NoticeInfo> implements INoticeInfoService {

}
