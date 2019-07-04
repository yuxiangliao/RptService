package com.inhe.rpt.common;

import java.util.UUID;

public class CodeUtil {
	
	public static String getCode(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
    
    public static String BlankLeft(String code,Integer len,String flag){
    	if(code == null)
    		code = "";
    	if(code.length()>len){
    		return code.substring(1, len);
    	}
    	String res = code;
    	for(int i=0;i<=len-code.length()-1;i++){
    		res = flag + res;
    	}
    	return res;
    }
   
    
    public static String BlankRight(String code,Integer len,String flag){
    	if(code == null)
    		code = "";
    	if(code.length()>len){
    		return code.substring(1, len);
    	}
    	String res = code;
    	for(int i=0;i<=len-code.length()-1;i++){
    		res = res + flag;
    	}
    	return res;
    }
    
    public static String AddBlank(int nums){
    	String result="";
    	for(int i=0;i<nums;i++)
    		result += " ";
    	
    	return result;
    }

    public static String getTaskRule(String cycle,String cycleType){
		String result="";
		switch (cycleType){
			case "1"://mins
				result = String.format("0 0/%s * * * ?", cycle);
				break;
			case "2"://hours
				result = String.format("0 0 0/%s * * ?", cycle);
				break;
			case "3"://days
				result = String.format("0 0 0 0/%s * ?", cycle);
				break;
			case "4"://months
				result = String.format("0 0 0 0 1/%s ?", cycle);
				break;
			case "5"://years
				result = String.format("0 0 0 0 0 1/%s", cycle);
				break;
			default:
				result = "0 0 0/1 * * ?";
		}
		return result;
	}

}
