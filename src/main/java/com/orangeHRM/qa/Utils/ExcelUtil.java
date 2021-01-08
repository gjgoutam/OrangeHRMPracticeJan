package com.orangeHRM.qa.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static String TEST_EXCEL_DATA = "C:\\Users\\Sharmita Bose\\eclipse-workspace\\OrangeHRMPractice\\src\\main\\java\\com\\orangeHRM\\qa\\testdata\\OrangeHRM_TestData.xlsx";
	public static Workbook book;
	public static Sheet workSheet;

	public static Object[][] SheetData(String SheetName) {
		Object sheetData[][] = null;
		try {
			FileInputStream ip = new FileInputStream(TEST_EXCEL_DATA);
			book = WorkbookFactory.create(ip);
			workSheet = book.getSheet(SheetName);
			sheetData = new Object[workSheet.getLastRowNum()][workSheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < workSheet.getLastRowNum(); i++) {
				for (int j = 0; j < workSheet.getRow(0).getLastCellNum(); j++) {
					sheetData[i][j] = workSheet.getRow(i + 1).getCell(j).toString();
				}
			}

			// Printing for reference.
			for (int i = 0; i < workSheet.getLastRowNum(); i++) {
				for (int j = 0; j < workSheet.getRow(0).getLastCellNum(); j++) {
					System.out.print(sheetData[i][j]);
				}
				System.out.println();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return sheetData;
	}

}
