package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataLibrary {

	public static Object[][] readExcelData(String excelfileName, String sheetName) throws IOException {
		//XSSFWorkbook wbook = new XSSFWorkbook("C:\\Users\\thamarais\\eclipse-workspace\\QVC_Dev\\data\\TestData.xlsx");
		XSSFWorkbook wbook = new XSSFWorkbook("./data/TestData.xlsx");

	//	./results/result.html
		//XSSFSheet sheet = wbook.getSheetAt(0);
		XSSFSheet sheet = wbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		System.out.println("row count"+rowCount);
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("column count"+colCount);


		Object[][] data = new Object[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				data[i-1][j] = stringCellValue;
			}
		}
		wbook.close();
		return data;
	}
}