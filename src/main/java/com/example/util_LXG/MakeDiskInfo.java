package com.example.util_LXG;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MakeDiskInfo {
	
	/**
	 * @author 廖兴广：构造器内嵌转换方法【舍弃】
	 * */
	public Map<String,String> ToMakeDiskInfo(Map<String,String> diskInfo) {
		
		/**
		 * @author 廖兴广转换部分
		 */
		
		Map<String,String> map = new HashMap<String, String>();
		
		Iterator it = diskInfo.entrySet().iterator();
		while(it.hasNext()){
		      java.util.Map.Entry entry = (java.util.Map.Entry)it.next();
		      
		      String[] keys = ((String) entry.getKey()).split("/");
		      String key;
		      
		      //total比较特殊，-1会导致数组溢出。
		      if(keys.length==0) {
		    	  key="total";
		      }else {
		      key = keys[keys.length-1];
		      }
		      
		      String value = (String) entry.getValue();
		      value = value.split("%")[0];
		      map.put(key, value);
		      
		      System.out.println("key； " + key + "   value：" +  value);
		}
		return map;
	}
	

}
