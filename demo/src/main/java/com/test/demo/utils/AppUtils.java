package com.test.demo.utils;

import java.util.Map;

public class AppUtils {
	
	public static boolean nullCheck(String str) {
		
	 if(str != null && !str.isEmpty() && str.trim().equals("")) {
		 return true;
	 }
	 return false;
	}
	
	public static Long convertLong(String str) {
		
		 if(str != null && !str.isEmpty() && !str.trim().equals("")) {
			 
			 if(str.trim().endsWith("s")) {
				 return Long.parseLong(str.trim().substring(0,str.trim().indexOf("s"))); 
			 }
				 
			 return Long.parseLong(str.trim());
		 }
		 return null;
		}
	
	public static boolean IsMapEmptyOrNull(Map map) {
		
		 if(map!=null && !map.isEmpty()  && map.size()>0) {
			 return true;
		 }
		 return false;
		}
		
}
