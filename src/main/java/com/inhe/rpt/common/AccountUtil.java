package com.inhe.rpt.common;

import java.util.HashMap;
import java.util.Map;

public class AccountUtil {
	public static Map<String, Object> accountE0 = new HashMap<>();
	
	static{
		Map<String, String> aC60 = new HashMap<>();
		Map<String, String> aC61 = new HashMap<>();
		Map<String, String> aC71 = new HashMap<>();
		aC60.put("caisse", "572100");
		aC60.put("collectif", "41150x");
		aC60.put("stampTax", "442860");
		aC60.put("cTva", "443155");
		aC60.put("dTva", "443150");
		aC60.put("cRer", "442155");
		aC60.put("dRer", "442150");
		aC60.put("cTreom", "442255");
		aC60.put("dTreom", "442250");
		aC60.put("cRti", "442855");
		aC60.put("dRti", "442850");
		
		aC71.put("caisse", "572100");
		aC71.put("collectif", "4165xx");
		aC71.put("stampTax", "442860");
		aC71.put("cTva", "443155");
		aC71.put("dTva", "443150");
		aC71.put("cRer", "442155");
		aC71.put("dRer", "442150");
		aC71.put("cTreom", "442255");
		aC71.put("dTreom", "442250");
		aC71.put("cRti", "442855");
		aC71.put("dRti", "442850");
		accountE0.put("c60", aC60);
		accountE0.put("c61", aC61);
		accountE0.put("c70", aC71);
		
		
	}
	
	public AccountUtil() {
		
	}
}
