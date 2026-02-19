package com.automation.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static void readDataFromExcel() throws Exception {
		File excelFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Test.xlsx");
		FileInputStream excelFis = new FileInputStream(excelFile);
//		HSSFWorkbook  -> for .xls
//		XSSFWorkbook   -> for .xlsx

		XSSFWorkbook excelWorkBook = new XSSFWorkbook(excelFis);
		XSSFSheet languagesSheet = excelWorkBook.getSheet("Languages");

		int usedRageCount = languagesSheet.getLastRowNum();
		System.out.println(usedRageCount);

		for (int i = 0; i <= usedRageCount; i++) {
			Row eachRow = languagesSheet.getRow(i);

			int eachRowColumnCount = eachRow.getLastCellNum();
			System.out.println(eachRowColumnCount);

			for (int j = 0; j < eachRowColumnCount; j++) {
				Cell eachCell = eachRow.getCell(j);

				switch (eachCell.getCellType()) {
				case STRING:
					String stringData = eachCell.getStringCellValue();
					System.out.println(stringData);
					break;
				case NUMERIC:
					double numberData = eachCell.getNumericCellValue();
					System.out.println(numberData);
					break;
				default:
					System.out.println("No match Found");
				}

			}
		}
		excelFis.close();
	}

	public static void readDataFromExcelUsingIterator() throws Exception {
		File excelFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Test.xlsx");
		FileInputStream excelFis = new FileInputStream(excelFile);

		XSSFWorkbook excelWorkBook = new XSSFWorkbook(excelFis);
		XSSFSheet languagesSheet = excelWorkBook.getSheet("Languages");

		Iterator<Row> allRows = languagesSheet.rowIterator();

		while (allRows.hasNext()) {
			Row eachRow = allRows.next();
			Iterator<Cell> allCells = eachRow.cellIterator();
			while (allCells.hasNext()) {
				Cell eachCell = allCells.next();

				switch (eachCell.getCellType()) {
				case STRING:
					String stringData = eachCell.getStringCellValue();
					System.out.println(stringData);
					break;
				case NUMERIC:
					double numberData = eachCell.getNumericCellValue();
					System.out.println(numberData);
					break;
				default:
					System.out.println("No match Found");
				}
			}
		}
		excelFis.close();
	}

	public static void main(String[] args) throws Exception {
//		readDataFromExcel();
		readDataFromExcelUsingIterator();
	}

}
