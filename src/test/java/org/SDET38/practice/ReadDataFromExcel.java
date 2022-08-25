package org.SDET38.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step1: read the file using file input stream
		
		FileInputStream fis = new FileInputStream(".\\Data\\testdata.xlsx");
		
		//step 2: create workbook
		Workbook workbook = WorkbookFactory.create(fis);
		
		//step 3: load the sheet
		Sheet sheet = workbook.getSheet("Sheet1");
		
		//step 4: navigate to row
		Row row = sheet.getRow(1);
		
		//step5: navigate to cell
		Cell cell = row.getCell(2);
		
		//step6: read the value inside the cell
		System.out.println(cell.getStringCellValue());

	}

}
