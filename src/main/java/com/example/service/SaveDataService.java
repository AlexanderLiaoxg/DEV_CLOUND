package com.example.service;

import java.sql.SQLException;
import java.util.Map;

import com.example.domain.MemoryInfo;

public interface SaveDataService {
	/**Redis**/
	public void saveCpuUsageToRedis(double CpuUsage);
	public void saveMemoryInofToRedis(MemoryInfo mem_info);
	public void saveDiskInfoToRedis(Map<String,String> disk_Info);
	
	/**Mysql
	 * @throws SQLException 
	 * @throws Exception **/
	public void saveCpuUsageToMysql() throws SQLException, Exception;
	//public void saveMemoryInofToMysql(MemoryInfo mem_info);
	//public void saveDiskInfoToMysql(Map<String,String> disk_Info);
	
	/**Hdfs/Hive**/
	public void saveCpuUsageToHdfs();
}
