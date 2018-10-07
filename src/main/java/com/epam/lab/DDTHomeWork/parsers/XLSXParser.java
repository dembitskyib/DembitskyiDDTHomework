package com.epam.lab.DDTHomeWork.parsers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXParser {
	public static Object[][] parse(String filePath) {
		List<Object[]> data = new ArrayList<>();
		try {
			XSSFWorkbook workBook = new XSSFWorkbook(new FileInputStream(filePath));
			XSSFSheet sheet = workBook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				ArrayList<Object> currentRow = new ArrayList<>();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					currentRow.add(cell.getStringCellValue());
				}
				data.add(currentRow.toArray());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data.toArray(new Object[][] {});
	}
}
