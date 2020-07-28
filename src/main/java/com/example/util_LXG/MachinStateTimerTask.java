package com.example.util_LXG;

import java.util.TimerTask;

import com.example.util.MachineStats;
import com.example.util.SSHException;
import com.example.util.SSHUtil;

public class MachinStateTimerTask extends TimerTask{
	
	public static  MachineStats machine_info;
	

	//String ip = "192.168.106.128";
	String ip = "39.108.251.216";
	int port = 22;
	String userName = "root";
	String password = "root123456~";

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
		machine_info = SSHUtil.getMachineInfo(ip, port, userName, password);
		} catch (SSHException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MachineStats getMachine_info() {
		return machine_info;
	}

}
