package com.example.util_LXG;

import org.apache.hadoop.conf.Configuration;
import org.apache.sqoop.Sqoop;
import org.apache.sqoop.tool.SqoopTool;
import org.apache.sqoop.util.OptionsFileUtil;

public class SqoopTest {
	  private static int importDataFromMysql() throws Exception {
	        String[] args = new String[] {
	                "--connect","jdbc:mysql://192.168.106.128:3306/Liaoxg?useUnicode=ture&characterEncoding=UTF-8&serverTimezone=GMT%2B8&characterEncoding=utf-8",
	                "--driver","com.mysql.cj.jdbc.Driver",
	                "-username","root",
	                "-password","123456",
	                "--table","2020_6_17",
	                "-m","1",
	                "--target-dir","/sqoopJavaTest"
	        };

	        String[] expandArguments = OptionsFileUtil.expandArguments(args);

	        SqoopTool tool = SqoopTool.getTool("import");

	        Configuration conf = new Configuration();
	        conf.set("fs.default.name", "hdfs://192.168.106.130:15002");//设置HDFS服务地址
	        Configuration loadPlugins = SqoopTool.loadPlugins(conf);

	        @SuppressWarnings("deprecation")
			Sqoop sqoop = new Sqoop((com.cloudera.sqoop.tool.SqoopTool) tool, loadPlugins);
	        return Sqoop.runSqoop(sqoop, expandArguments);
	    }

	
	public static void main(String[] args1) throws Exception {
		 importDataFromMysql();
	}
}
