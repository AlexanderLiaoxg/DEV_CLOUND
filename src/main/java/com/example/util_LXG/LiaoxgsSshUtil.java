package com.example.util_LXG;

import java.util.ArrayList;

import com.example.domain.HdfsReportInfo;
import com.example.util.SSHException;
import com.example.util.SSHTemplate;
import com.example.util.SSHTemplate.DefaultLineProcessor;
import com.example.util.SSHTemplate.Result;
import com.example.util.SSHTemplate.SSHCallback;
import com.example.util.SSHTemplate.SSHSession;

/**
 * @author 廖兴广 调用老师的SSHtemplate自定义工具类
 **/
public class LiaoxgsSshUtil {
	String ip = "192.168.106.128";
	int port = 22;
	String userName = "e3base";
	String password = "root123456";

	/** 调用ssh模板用来执行Linux命令 **/
	private final static SSHTemplate sshTemplate = new SSHTemplate();

	/** 解决跨域传输问题 **/
	private static HdfsReportInfo DFS_INFO = new HdfsReportInfo();

	private static ArrayList<HdfsReportInfo> DFS_LIST = new ArrayList<>();

	/** 获取hdfs report信息 **/
	public ArrayList<HdfsReportInfo> getHdfsReport() throws SSHException {
		String commond = "/e3base/hadoop/bin/hdfs dfsadmin -report";
		sshTemplate.execute(ip, port, userName, password, new SSHCallback() {
			public Result call(SSHSession session) {
				// 解析report命令
				session.executeCommand(commond, new DefaultLineProcessor() {
					public void process(String line, int lineNum) throws Exception {

						/**
						 * @author 廖兴广 每一行进行解析
						 **/

						// 总数据部分
						int paramIndex = line.indexOf(": ");
						String paramName = null;
						String param = null;

						if (paramIndex > 0) {
							paramName = line.substring(0, paramIndex);
							param = line.substring(paramIndex, line.length());
							//System.out.println("*****************" + paramName + "**************");
						} else {
							// throw new Exception("空行，无关信息行，忽略此信息不影响");
						}

						if (lineNum < 11) {
							switch (paramName) {
							case "DFS Remaining":
								DFS_INFO.setDfs_remaining(param);
								break;
							case "DFS Used":
								DFS_INFO.setDfs_used(param);
								break;
							case "DFS Used%":
								;
								DFS_INFO.setDfs_usage(translateStringToNum(param));
								addDfsObject();
								break;
							// 不需要检测的数据也会在这，舍弃 default:throw new Exception("错误信息：未识别出DFS信息参数名称");
							default:
								break;
							}
						} else if (paramIndex > 0) {

							// 先对上一个模块进行存储，flag的初始化应用
							if (DFS_INFO.getDfs_remaining_usage() != null) {
								addDfsObject();
							} else {
								switch (paramName) {
								case "DFS Remaining":
									DFS_INFO.setDfs_remaining(param);
									break;
								case "DFS Used":
									DFS_INFO.setDfs_used(param);
									break;
								case "DFS Used%":
									;
									DFS_INFO.setDfs_usage(translateStringToNum(param));
									break;
								case "DFS Remaining%":
									;
									DFS_INFO.setDfs_remaining_usage(translateStringToNum(param));
									addDfsObject();
									break;
								default:
									break;
								}
							}

						}
					}
				});
				System.out.print(DFS_LIST.toString());
				return null;
			}

		});
		return DFS_LIST;

	}

	public String executeSqoop(String sqoopCommand) throws SSHException {

		Result rst = sshTemplate.execute(ip, port, userName, password, new SSHCallback() {
			public Result call(SSHSession session) {
				return session.executeCommand(sqoopCommand);
			}
		});
		return "执行sqoop命令出错未执行：sshTemplate错误\n";

	}

	/**
	 * @author 廖兴广 方法中封装的共性代码块
	 **/

	private void addDfsObject() {
		HdfsReportInfo t = new HdfsReportInfo();
		t.setDfs_remaining(DFS_INFO.getDfs_remaining());
		t.setDfs_usage(DFS_INFO.getDfs_usage());
		t.setDfs_used(DFS_INFO.getDfs_used());

		/**
		 * @author 廖兴广 下面这个因为总的信息没有其实也是一个赋null的过程
		 **/

		t.setDfs_remaining_usage(DFS_INFO.getDfs_remaining_usage());
		DFS_LIST.add(t);

		// 一个周,设置一个阀值
		DFS_INFO.setDfs_remaining_usage(null);

	}
	
	//这个可以留给后面自己需要使用的时候使用
	//内存因为有单位的缘故，不转换只转换使用率
	public double translateStringToNum(String str) {
		double data = 0;
        if (str != null && str.length() != 0) {
            StringBuffer bf = new StringBuffer();

            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c >= '0' && c <= '9') {
                    bf.append(c);
                } else if (c == ',') {
                    continue;
                } else {
                    if (bf.length() != 0) {
                        break;
                    }
                }
            }
            try {
            	data = Double.parseDouble(bf.toString());
            } catch (Exception e) {
            }
        }
        return data;
	}
	
	

	public static void main(String[] args) throws SSHException {
		new LiaoxgsSshUtil().getHdfsReport();
	}

}
