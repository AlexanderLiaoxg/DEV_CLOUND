package com.example.domain;

public class MemoryInfo {
	double totalMemory;
	double freeMemory;
	double usageMemory;
	double allocatedMemory;
	public double getTotalMemory() {
		return totalMemory;
	}
	public void setTotalMemory(double totalMemory) {
		this.totalMemory = totalMemory;
	}
	public double getFreeMemory() {
		return freeMemory;
	}
	public void setFreeMemory(double freeMemory) {
		this.freeMemory = freeMemory;
	}
	public double getUsageMemory() {
		return usageMemory;
	}
	public void setUsageMemory(double usageMemory) {
		this.usageMemory = usageMemory;
	}
	public double getAllocatedMemory() {
		return allocatedMemory;
	}
	public void setAllocatedMemory(double allocatedMemory) {
		this.allocatedMemory = allocatedMemory;
	}
	@Override
	public String toString() {
		return "MemoryInfo [totalMemory=" + totalMemory + ", freeMemory=" + freeMemory + ", usageMemory=" + usageMemory
				+ ", allocatedMemory=" + allocatedMemory + "]";
	}
	
}
