package com.example.controller;

import java.sql.SQLException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.example.service.GetDataService;
import com.example.service.SaveDataService;
import com.example.service.SshService;
import com.example.util.SSHException;


@Controller
public class MachineInfoController {
	@Autowired
	SshService sshService;
	
	@Autowired
	SaveDataService saveDataService;
	
	@Autowired
	GetDataService getDataService;

	@ResponseBody
	@RequestMapping("/getCpuUsage")
	public String getCpuUse(Model model) throws SQLException  {
		//System.out.println("进入到getCpuUse");		
		double CpuUsage = sshService.getCpuUsage();
		
		JSONObject result = new JSONObject();  
        result.put("CpuUsage", String.valueOf(CpuUsage)); 
        saveDataService.saveCpuUsageToRedis(CpuUsage);
        //System.out.println(result);
		return result.toString();
	}
	

	@ResponseBody
	@RequestMapping("/getMemoryUsage")
	public String getMemoryUse(Model model)  {
		System.out.println("进入到getMemoryUse");		
		
		JSONObject result = new JSONObject(sshService.getMemoryInfo());  
		//result.put("DiskInfo", String.valueOf(sshService.getCpuUsage()));  
        System.out.println(result);
		return result.toString();
	}
	
	/**
	 * lxg:这里是否跟Memory共享一个MachineState对象实现优化
	 * @throws SSHException 
	 * */
	@ResponseBody
	@RequestMapping("/getDiskInfo")
	public String getDiskInfo(Model model) throws SSHException  {
		System.out.println("进入到getDiskInfo");		
		
		JSONObject result = new JSONObject(sshService.getDiskInfo());  
		//result.put("DiskInfo", String.valueOf(sshService.getCpuUsage()));  
       // System.out.println("Disk： " + result);
		return result.toString();
	}
	
	
	
	/**
	 * @author 廖兴广
	 * @date 2020年7月27日
	 * @version 1.0
	 * 编者说：获取hdfs性能数据
	 */
	
	@ResponseBody
	@RequestMapping("/getHdfsInfo")
	public String getHdfsInfo() throws SSHException  {
		List hdfsInfos = sshService.getHdfsInfo();
		JSONArray result = new JSONArray(hdfsInfos);
		return result.toString();
	}
	
	
	/**
	 **@author 廖兴广 历史数据获取
	 */
	@ResponseBody
	@RequestMapping("/getHistoryCpuUsage")
	public  String  getHistoryCpuUsage(Model model) throws SSHException  {
		List historyDatas = getDataService.getHistoryCpuUsageFromMysql();
		JSONArray result = new JSONArray(historyDatas);  
		System.out.println(result.toString());
		return result.toString();
	}
	
	
}
