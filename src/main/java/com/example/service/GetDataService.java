package com.example.service;

import java.util.List;

import com.example.domain.CpuInfo;

public interface GetDataService {
	/**获取MySQL的历史数据**/
	public List<CpuInfo>  getHistoryCpuUsageFromMysql();
}
