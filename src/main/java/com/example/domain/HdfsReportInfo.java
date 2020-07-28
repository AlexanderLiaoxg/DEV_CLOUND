package com.example.domain;

public class HdfsReportInfo {
	/**hdfs集群总和分机的耦合信息**/
	String dfs_remaining;
	String dfs_used;
	Double dfs_usage;
	
	/**分机信息**/
	Double dfs_remaining_usage;

	//常用生成
	public String getDfs_remaining() {
		return dfs_remaining;
	}

	public void setDfs_remaining(String dfs_remaining) {
		this.dfs_remaining = dfs_remaining;
	}

	public String getDfs_used() {
		return dfs_used;
	}

	public void setDfs_used(String dfs_used) {
		this.dfs_used = dfs_used;
	}

	public Double getDfs_usage() {
		return dfs_usage;
	}

	public void setDfs_usage(Double dfs_usage) {
		this.dfs_usage = dfs_usage;
	}

	public Double getDfs_remaining_usage() {
		return dfs_remaining_usage;
	}

	public void setDfs_remaining_usage(Double dfs_remaining_usage) {
		this.dfs_remaining_usage = dfs_remaining_usage;
	}

	@Override
	public String toString() {
		return "HdfsReportInfo [dfs_remaining=" + dfs_remaining + ", dfs_used=" + dfs_used + ", dfs_usage=" + dfs_usage
				+ ", dfs_remaining_usage=" + dfs_remaining_usage + "]";
	}
	
	
}
