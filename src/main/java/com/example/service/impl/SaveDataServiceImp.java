package com.example.service.impl;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.domain.MemoryInfo;
import com.example.service.SaveDataService;
import com.example.util_LXG.JDBC;

@Service
public class SaveDataServiceImp implements SaveDataService {

	public SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	RedisTemplate redisTemplate;

	@Override
	public void saveCpuUsageToRedis(double CpuUsage) {
		// TODO Auto-generated method stub
//		JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) redisTemplate.getConnectionFactory();
//		jedisConnectionFactory.setDatabase(2);

		Date now = new Date();
		String nowTime = format.format(now);
		redisTemplate.opsForValue().set(nowTime, CpuUsage);

		// 不适用Object取出回导致类型问题
		Object info = redisTemplate.opsForValue().get(nowTime);
		System.out.println("取出数据为：" + info);
	}

	@Override
	public void saveMemoryInofToRedis(MemoryInfo mem_info) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveDiskInfoToRedis(Map<String, String> disk_Info) {
		// TODO Auto-generated method stub

	}

	/**
	 * @author 廖兴广Redis数据持久化到MySQL
	 * @throws Exception
	 **/

	@Override
	public void saveCpuUsageToMysql() throws Exception {
		// TODO Auto-generated method stub
		/**
		 * @author 廖兴广通过自己写的JDBC单例工具类来获取MySQL的Connection
		 */
		Connection con = new JDBC().con;
		Statement stat = (Statement) con.createStatement();

		// 获取Redis库所有数，时间片持久化
		Set<String> keys = redisTemplate.keys("*");
		HashMap<Object, Object> cpuMap = new HashMap<>();
		for (String key : keys) {
			Object cpuUsage = redisTemplate.opsForValue().get(key);
			String sql = "insert into cpu_usage_one_day values(" + "'" + key + "'" + "," + cpuUsage + ")";
			System.out.println(key + ":  " + cpuUsage);
			stat.addBatch(sql);
		}
		stat.executeBatch();

		// 清空Redis缓存
		// 找不到flush方法
		// redisTemplate.opsForCluster().flushDb(node);
		redisTemplate.delete(keys);
	}

	@Override
	public void saveCpuUsageToHdfs() {
		// TODO Auto-generated method stub
	}

}
