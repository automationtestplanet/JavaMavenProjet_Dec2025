package com.automation.csv;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class ReadDataFromCsv {
	
	public static void main(String[] args) {
		
		File csvFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\CreateUser.csv");
		CsvUtils csvUtils = new CsvUtils();
		 
		List<Map<String, String>> data = csvUtils.readDataFromCsv(csvFile.getAbsolutePath());
		
		Iterator<Map<String, String>> iterator = data.iterator();
		
		while (iterator.hasNext()) {
			
			Map<String, String> createUser = iterator.next();
			
			System.out.println("Name: " +createUser.get("Name"));
			System.out.println("Job: " +createUser.get("Job"));
		}
		 
	}
	

}
