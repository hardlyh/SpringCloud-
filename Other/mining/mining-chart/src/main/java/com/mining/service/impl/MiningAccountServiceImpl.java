package com.mining.service.impl;

import com.mining.domain.MiningAccount;
import com.mining.mapper.MiningAccountMapper;
import com.mining.service.MiningAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 挖矿用户表 服务实现类
 * </p>
 *
 * @author liyh
 * @since 2020-08-06
 */
@Service
public class MiningAccountServiceImpl extends ServiceImpl<MiningAccountMapper, MiningAccount> implements MiningAccountService {

}
