package com.automation.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class CreateUser {
	
	public static void main(String[] args) {
		System.out.println("Program running");
	}
	
	public List<Map<String, String>> readDataFromCsv(String csvFilePath, String sheetName) {
		return null;
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

