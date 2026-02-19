package com.automation.xml;


import java.nio.file.Paths;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ReadDataFromXml {

	public static void main(String[] args) throws Exception {
		String filePath = System.getProperty("user.dir")+"//src//main//resources//Credentials.xml";		
		XmlMapper xmlMap = new XmlMapper();
		JSONObject xmlObj = xmlMap.readValue(Paths.get(filePath).toFile(), JSONObject.class);
		System.out.println(xmlObj.get("UserName"));
		System.out.println(xmlObj.get("Password"));
	}

}
