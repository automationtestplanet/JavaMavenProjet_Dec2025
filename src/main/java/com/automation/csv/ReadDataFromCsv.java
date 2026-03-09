package com.automation.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class ReadDataFromCsv {

	public static void main(String[] args) throws Exception {
		String filePath = System.getProperty("user.dir") + "//src//main//resources//CreateUser.csv";
		CSVReader csvFile = new CSVReader(new FileReader(new File(filePath)));
		List<String[]> allROws = csvFile.readAll();
		allROws.forEach(eachRowData -> System.out.println(eachRowData[0] + " " + eachRowData[1]));
	}
}
