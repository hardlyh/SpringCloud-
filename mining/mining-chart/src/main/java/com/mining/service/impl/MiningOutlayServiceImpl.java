package com.mining.service.impl;

import com.mining.domain.MiningIncome;
import com.mining.domain.MiningOutlay;
import com.mining.mapper.MiningOutlayMapper;
import com.mining.service.MiningOutlayService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 挖矿支出 服务实现类
 * </p>
 *
 * @author liyh
 * @since 2020-08-06
 */
@Service
public class MiningOutlayServiceImpl extends ServiceImpl<MiningOutlayMapper, MiningOutlay> implements MiningOutlayService {

	
	@Autowired
	private MiningOutlayMapper outlayMapper;
	
	@Override
	public MiningOutlay countByDate(String startTime,String endTime) {
		return outlayMapper.countByDate(startTime,endTime);
	}
	
	public List<MiningOutlay> countByDateGroup(String startTime,String endTime) {
		return outlayMapper.countByDateGroup(startTime,endTime);
	}

	@Override
	public List<MiningOutlay> listByDate(String dateTime) {
		QueryWrapper<MiningOutlay> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("outlay_day", dateTime);
		List<MiningOutlay> list = list(queryWrapper);
		return list;
	}

	@Override
	public MiningOutlay countInComeByDate(String startTime, String endTime) {
		return outlayMapper.countInComeByDate(startTime,endTime);
	}

	@Override
	public List<MiningOutlay> countInComeByDateGroup(String startTime, String endTime) {
		return outlayMapper.countInComeByDateGroup(startTime,endTime);
	}

	@Override
	public List<MiningOutlay> listInComeByDate(String dateTime) {
		QueryWrapper<MiningOutlay> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("line_number", dateTime);
		List<MiningOutlay> list = list(queryWrapper);
		return list;
	}

}
