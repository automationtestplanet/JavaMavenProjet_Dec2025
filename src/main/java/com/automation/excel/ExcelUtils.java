package com.automation.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public List<Map<String, String>> readDataFromExcel(String excelFilePath, String sheetName) {
		List<Map<String, String>> dataList = new ArrayList<>();
		try {
			File excelFile = new File(excelFilePath);
			FileInputStream excelFis = new FileInputStream(excelFile);
			XSSFWorkbook excelWorkBook = new XSSFWorkbook(excelFis);
			XSSFSheet xssfSheet = excelWorkBook.getSheet(sheetName);
			List<String> columnHeaders = readColumnHeaders(xssfSheet);
//			System.out.println(columnHeaders);

			int usedRageCount = xssfSheet.getLastRowNum();

			for (int i = 1; i <= usedRageCount; i++) {
				Map<String, String> eachRowDataMap = new LinkedHashMap<>();
				Row eachRow = xssfSheet.getRow(i);
				int eachRowColumnCount = eachRow.getLastCellNum();
				for (int j = 0; j < eachRowColumnCount; j++) {
					Cell eachCell = eachRow.getCell(j);
					switch (eachCell.getCellType()) {
					case STRING:
						String stringData = eachCell.getStringCellValue();
						eachRowDataMap.put(columnHeaders.get(j), stringData);
						break;
					case NUMERIC:
						double numberData = eachCell.getNumericCellValue();
						eachRowDataMap.put(columnHeaders.get(j), String.valueOf(numberData));

						break;
					default:
						System.out.println("No match Found");
					}
				}
				dataList.add(eachRowDataMap);
			}
			excelFis.close();
		} catch (Exception e) {
			System.out.println("Exception Occurred while reading the data from excel: " + e.getMessage());
		}

		return dataList;
	}

	public List<String> readColumnHeaders(XSSFSheet xssfSheet) {
		List<String> columnHeadersList = new ArrayList<>();

		Row columnHeadersRow = xssfSheet.getRow(0);
		Iterator<Cell> allCells = columnHeadersRow.cellIterator();

		while (allCells.hasNext()) {
			Cell eachCell = allCells.next();

			switch (eachCell.getCellType()) {
			case STRING:
				String stringData = eachCell.getStringCellValue();
				columnHeadersList.add(stringData);
				break;
			case NUMERIC:
				double numberData = eachCell.getNumericCellValue();
				columnHeadersList.add(String.valueOf(numberData));
				break;
			default:
				System.out.println("No match Found");
			}
		}
		return columnHeadersList;
	}
}
