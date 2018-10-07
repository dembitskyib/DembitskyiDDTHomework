package com.epam.lab.DDTHomeWork.pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GmailPage {
	protected WebDriver driver;
	protected int pageUpdateTimeOut;

	public GmailPage(WebDriver driver, int pageUpdateTimeOut) {
		this.driver = driver;
		this.pageUpdateTimeOut = pageUpdateTimeOut;
	}

	public void redirectToPage(String url) {
		driver.get(url);
	}

	public boolean isURLCorrect(String expectedURL) {
		boolean isComparisionFailed = false;
		try {
			(new WebDriverWait(driver, pageUpdateTimeOut)).until(ExpectedConditions.urlContains(expectedURL));
		} catch (Exception ex) {
			isComparisionFailed = true;
		}
		return !isComparisionFailed;
	}
}
