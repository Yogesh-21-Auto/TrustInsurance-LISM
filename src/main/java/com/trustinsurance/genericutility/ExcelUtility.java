package com.trustinsurance.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache POi libraries , which used to handle Microsoft
 * Excel sheet
 * 
 * @author acer
 *
 */

public class ExcelUtility implements Iconstants {
	/**
	 * its used to read the data from Excel-Workbook based on below
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return String data
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(Iconstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.toString();
		return data;
	}

	/**
	 * used to get the last used row number on specified Sheet
	 * 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(Iconstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		workbook.close();
		return sheet.getLastRowNum();
	}

	/**
	 * used to write data back to Excel based on below parameter
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */

	public void setDataExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream(Iconstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(celNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(Iconstants.excelFilePath);
		workbook.write(fos);
		workbook.close();

	}

}
