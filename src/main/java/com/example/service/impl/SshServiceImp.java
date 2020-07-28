package com.example.service.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.domain.HdfsReportInfo;
import com.example.domain.MemoryInfo;
import com.example.service.SshService;
import com.example.util.MachineStats;
import com.example.util.SSHException;
import com.example.util_LXG.LiaoxgsSshUtil;
import com.example.util_LXG.MachinStateTimerTask;
import com.example.util_LXG.MakeDiskInfo;

@Service
public class SshServiceImp implements SshService{
	
	/**
	 * @author 廖兴广
	 * @description:所以监控图表均使用一个MachinState对象，非锁（锁：数据的同一性这里不适用）
	 * static对象在注入对象的时候便生成
	 */
	public static MachinStateTimerTask machineTimerTask;
	private static MachineStats machine_info;
	
	

	@Override
	public double getCpuUsage() {
		machine_info =  MachinStateTimerTask.getMachine_info();
		System.out.println("CPU使用率：" + machine_info.getCpuUsage());
		double CpuUsage = Double.valueOf(machine_info.getCpuUsage());
		return CpuUsage;
		//出错设定
		/* return -1; */
	}


	@Override
	public MemoryInfo getMemoryInfo() {
		// TODO Auto-generated method stub
		
		machine_info =  MachinStateTimerTask.getMachine_info();
		MemoryInfo mem_info = new MemoryInfo();

		
		//MachineStats machine_info = SSHUtil.getMachineInfo(ip, port, userName, password);
		mem_info.setTotalMemory(Double.valueOf(machine_info.getMemoryTotal()));
		mem_info.setFreeMemory(Double.valueOf(machine_info.getMemoryFree()));
		mem_info.setUsageMemory(Double.valueOf(machine_info.getMemoryUsageRatio()));
		
		double allocatedMemory = Double.valueOf(machine_info.getMemoryTotal())-Double.valueOf(machine_info.getMemoryFree());
		mem_info.setAllocatedMemory(allocatedMemory);
		
		return mem_info;
	}


	@Override
	public Map<String, String> getDiskInfo() throws SSHException {
		// TODO Auto-generated method stub
		machine_info =  MachinStateTimerTask.getMachine_info();
		
		System.out.println("进入到Diskimpl" + new MakeDiskInfo().ToMakeDiskInfo(machine_info.getDiskUsageMap()).toString());		
		
		return new MakeDiskInfo().ToMakeDiskInfo(machine_info.getDiskUsageMap());
	}


	@Override
	public ArrayList<HdfsReportInfo> getHdfsInfo() throws SSHException {
		// TODO Auto-generated method stub
		return new LiaoxgsSshUtil().getHdfsReport();
	}
	


}
