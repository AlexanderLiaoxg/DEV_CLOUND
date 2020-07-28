package com.example.util_LXG;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
	public static Connection con = null;

	/**
	 * @author 廖兴广随手写的，饿汉模式
	 * **/
	public JDBC() throws Exception {
		if(con==null) {
			con = createConnection();
		}else {
			
		}
	}
	
	public static Connection createConnection() throws Exception {
		// String Driver="org.mm.mysql.Driver";
		String Driver = "com.mysql.cj.jdbc.Driver";
		String Url = "jdbc:mysql://localhost:3306/stq_demo?useUnicode=ture&characterEncoding=UTF-8&serverTimezone=GMT%2B8&characterEncoding=utf-8";
		String User = "root";
		String Password = "123456";

		Class.forName(Driver);
		con = DriverManager.getConnection(Url, User, Password);
		System.out.println("connect sucess!");
		java.sql.Statement stmt = con.createStatement();
		return con;
	}

//	public static void main(String[] args) throws Exception {
//		con = new JDBC().con;
//		
//		Statement stat = (Statement) con.createStatement();
//		 
//		//获取Redis库所有数，时间片持久化
//		
//		SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		
//		Date date=new Date();
//		
//		String time = format.format(date);
//		System.out.println("我想要展示的样子：" + time);
//		
//		Date time2 = format.parse(time);
//		System.out.println("数据库该存入的样子：" + time2);
//		
//		
////		String time = "Thu Jul 23 16:38:08 CST 2020";
//		
//
//			for(int i=0;i<2;i++) {
//			String sql= "insert into cpu_usage_one_day values(" + "'" + time + "'" + ",6.1)";
//			stat.execute(sql);
//			}
//			//stat.executeBatch();
//			System.out.println("插入成果");
//			
//	}


}
