package com.example.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.CpuInfo;

@Mapper
public interface HistoryDataDao {

	//@MapKey("time") // 这个只能查询单个
	@Select("select * from cpu_usage_one_day")
	public ArrayList<CpuInfo> getHistoryCpuUsage();
}
