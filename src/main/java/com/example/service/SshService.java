package com.example.service;

import java.util.ArrayList;
import java.util.Map;

import com.example.domain.HdfsReportInfo;
import com.example.domain.MemoryInfo;
import com.example.util.SSHException;

public interface SshService {
	public double getCpuUsage();
	public MemoryInfo getMemoryInfo();
	public Map<String, String> getDiskInfo() throws SSHException;
	public ArrayList<HdfsReportInfo> getHdfsInfo() throws SSHException;
}
