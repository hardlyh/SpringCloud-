package com.mining.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.domain.MiningOutlay;

/**
 * <p>
 * 挖矿支出 服务类
 * </p>
 *
 * @author liyh
 * @since 2020-08-06
 */
public interface MiningOutlayService extends IService<MiningOutlay> {
	MiningOutlay countByDate(String startTime,String endTime);

	List<MiningOutlay> countByDateGroup(String startTime,String endTime);
	
	List<MiningOutlay> listByDate(String dateTime);
	
	MiningOutlay countInComeByDate(String startTime,String endTime);

	List<MiningOutlay> countInComeByDateGroup(String startTime,String endTime);
	
	List<MiningOutlay> listInComeByDate(String dateTime);
}
