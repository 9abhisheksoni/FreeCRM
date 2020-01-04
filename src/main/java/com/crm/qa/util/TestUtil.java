package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long Page_Load_Timeout = 20;
	public static long Implicit_Wait = 20;

	public void switchToFrame(String frm) {
		driver.switchTo().frame(frm);
	}

	public static String TESTDATAFILE = "C:\\RealTimeProject\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMtestData.xlsx";
	static Workbook book;
	static Sheet sht;

	public static Object[][] getData(String sheet) throws InvalidFormatException {
		FileInputStream file = null;

		try {
			file = new FileInputStream(TESTDATAFILE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sht = book.getSheet(sheet);

		Object[][] data = new Object[sht.getLastRowNum()][sht.getRow(0).getLastCellNum()];

		for (int i = 0; i < sht.getLastRowNum(); i++) {
			for (int k = 0; k < sht.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sht.getRow(i + 1).getCell(k).toString();

			}
		}

		return data;
	}

	/*
	 * public static void takeScreenshotAtEndOfTest() { File src =
	 * ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 * FileUtils.copyFile(src, new File("C://Naveen Automation//" +
	 * System.currentTimeMillis().png));
	 * 
	 * }
	 */

}
