package com.automation.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadDataFromJson {

	public static void main(String[] args) throws Exception {
		String filePath = System.getProperty("user.dir")+"//src//main//resources//LoginDetails.json";
		JSONParser jParse = new JSONParser();
		JSONObject jObject = (JSONObject)jParse.parse(new FileReader(new File(filePath)));
		System.out.println(jObject.get("userName"));
		System.out.println(jObject.get("password"));
		
		System.out.println("-----------------------------------------------------------------");
		ObjectMapper objMapper = new ObjectMapper();
		JSONObject jObject2 = objMapper.readValue(Paths.get(filePath).toFile(), JSONObject.class);
		System.out.println(jObject2.get("userName"));
		System.out.println(jObject2.get("password"));
		
	}

}
