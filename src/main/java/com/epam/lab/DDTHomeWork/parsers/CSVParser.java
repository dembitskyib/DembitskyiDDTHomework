package com.epam.lab.DDTHomeWork.parsers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
	public static Object[][] parse(String filePath) {
		List<Object[]> data = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String currentRow;
			while ((currentRow = br.readLine()) != null) {
				Object[] rowValuesList = currentRow.split(",");
				data.add(rowValuesList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data.toArray(new Object[][] {});
	}
}
