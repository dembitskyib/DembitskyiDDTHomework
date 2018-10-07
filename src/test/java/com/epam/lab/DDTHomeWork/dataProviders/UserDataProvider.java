package com.epam.lab.DDTHomeWork.dataProviders;

import org.testng.annotations.DataProvider;

import com.epam.lab.DDTHomeWork.parsers.CSVParser;
import com.epam.lab.DDTHomeWork.parsers.PropertyParser;
import com.epam.lab.DDTHomeWork.parsers.XLSXParser;

public class UserDataProvider {
	private final static String PROPERTIES_PATH = "src/test/resources/config.properties";

	@DataProvider(name = "userDataCSV", parallel = true)
	public static Object[][] provideCSV() {
		return CSVParser.parse(new PropertyParser(PROPERTIES_PATH).getProperty("userCSVListPath"));
	}

	@DataProvider(name = "userDataXLSX", parallel = true)
	public static Object[][] provideXLSX() {
		return XLSXParser.parse(new PropertyParser(PROPERTIES_PATH).getProperty("userXLSXListPath"));
	}
}