package com.automation.csv;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class CsvUtils {
		
	public List<Map<String, String>> readDataFromCsv(String filePath) {
		List<Map<String, String>> dataList = new ArrayList<>();
		try {
		
			FileReader fr= new FileReader(filePath);
			
			List<String> lines = new ArrayList<>();
			StringBuilder line = new StringBuilder();
			
			int ch;
			
			while ((ch = fr.read())!= -1) {
				
				if (ch== '\n') {
					lines.add(line.toString());
					line.setLength(0);
				} else {
					line.append((char) ch);
				}
			}
			
			if (line.length()>0) {
				lines.add(line.toString());
			}
			fr.close();
			
			Iterator<String> iterator = lines.iterator();
			
			String headerLine = iterator.next();
			String[] headers = headerLine.split(",");
			
			while (iterator.hasNext()) {
				
				String rowLine = iterator.next();
				String[] values = rowLine.split(",");
				
				Map<String, String> rowMap = new HashMap<> ();
				for (int i=0; i<headers.length; i++) {
					rowMap.put(headers[i].trim(), values[i].trim());
				}
				dataList.add(rowMap);
			}
			
		} catch (Exception e) {
			System.out.println("Exception Occurred while reading the data from excel: " + e.getMessage());
		}

		return dataList;
	}
}
