package com.mining.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mining.domain.MiningOutlay;

/**
 * <p>
 * 挖矿支出 Mapper 接口
 * </p>
 *
 * @author liyh
 * @since 2020-08-06
 */
public interface MiningOutlayMapper extends BaseMapper<MiningOutlay> {
	
	public MiningOutlay countByDate(String startTime,String endTime);
	
	public List<MiningOutlay> countByDateGroup(String startTime,String endTime);
	
	public MiningOutlay countInComeByDate(String startTime,String endTime);
	
	public List<MiningOutlay> countInComeByDateGroup(String startTime,String endTime);
}
