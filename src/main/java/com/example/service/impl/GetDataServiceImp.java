package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.HistoryDataDao;
import com.example.domain.CpuInfo;
import com.example.service.GetDataService;

@Service
public class GetDataServiceImp implements GetDataService{

	@Autowired
	HistoryDataDao historyDataDao;
	
	@Override
	public List<CpuInfo> getHistoryCpuUsageFromMysql() {
		// TODO Auto-generated method stub
		CpuInfo cpuInfo;
		List<CpuInfo> infos  = historyDataDao.getHistoryCpuUsage();
//		Map<String,Double> map = new HashMap<>();
//		
//		Iterator<CpuInfo> it = infos.iterator();
//		while(it.hasNext()) {
//			cpuInfo = it.next();
//			map.put(cpuInfo.getTime(), cpuInfo.getCpu_usage());
//			System.out.println(cpuInfo.toString());
//		}
		return infos;
	}

}
