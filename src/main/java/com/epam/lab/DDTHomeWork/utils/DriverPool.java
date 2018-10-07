package com.epam.lab.DDTHomeWork.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.epam.lab.DDTHomeWork.parsers.PropertyParser;

public class DriverPool {
	private static final String PROPERTIES_PATH = "src/test/resources/config.properties";
	private static ThreadLocal<WebDriver> driverPool = ThreadLocal.withInitial(() -> {
		return initDriver();
	});

	public static WebDriver getThreadDriver() {
		return driverPool.get();
	}

	public static void quitDriver() {
		driverPool.get().quit();
		driverPool.remove();
	}

	private static WebDriver initDriver() {
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().timeouts()
				.implicitlyWait(new PropertyParser(PROPERTIES_PATH).getIntProperty("implicitlyWait"), TimeUnit.SECONDS);
		return webDriver;
	}
}
