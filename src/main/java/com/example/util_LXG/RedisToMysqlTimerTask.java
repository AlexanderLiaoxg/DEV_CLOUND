package com.example.util_LXG;

import java.util.TimerTask;

import com.example.service.SaveDataService;

public class RedisToMysqlTimerTask extends TimerTask{
	

	/**
	 * @author 廖兴广定时任务中无法自动装配，采用手动编撰全局配置工具类手动获取Bean实例。
	 * **/
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		SaveDataService saveDataService = (SaveDataService) ApplicationContextUtil.getBean("saveDataServiceImp");
		
		try {
			saveDataService.saveCpuUsageToMysql();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
