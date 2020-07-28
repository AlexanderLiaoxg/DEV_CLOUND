package com.example.domain;

public class CpuInfo{
	String time;
	Double cpu_usage;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Double getCpu_usage() {
		return cpu_usage;
	}
	public void setCpu_usage(Double cpu_usage) {
		this.cpu_usage = cpu_usage;
	}
	@Override
	public String toString() {
		return "CpuInfo [time=" + time + ", cpu_usage=" + cpu_usage + "]";
	}


}
