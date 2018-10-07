package com.epam.lab.DDTHomeWork;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.lab.DDTHomeWork.businessObjects.GmailMessageBO;
import com.epam.lab.DDTHomeWork.businessObjects.LoginBO;
import com.epam.lab.DDTHomeWork.dataModels.Message;
import com.epam.lab.DDTHomeWork.dataProviders.UserDataProvider;
import com.epam.lab.DDTHomeWork.parsers.JAXBParser;
import com.epam.lab.DDTHomeWork.parsers.PropertyParser;
import com.epam.lab.DDTHomeWork.utils.DriverPool;

public class GmailSendTest {
	private final String PROPERTIES_PATH = "src/test/resources/config.properties";
	private Message message;
	private PropertyParser propertyParser;
	private int pageUpdateTimeOut;

	@BeforeClass
	public void parametersSetup() {
		propertyParser = new PropertyParser(PROPERTIES_PATH);
		System.setProperty("webdriver.chrome.driver", propertyParser.getProperty("chromeDriverPath"));
		message = JAXBParser.getMessage(propertyParser.getProperty("messagePath"));
		pageUpdateTimeOut = propertyParser.getIntProperty("pageUpdateTimeOut");
	}

	@Test(dataProvider = "userDataXLSX", dataProviderClass = UserDataProvider.class)
	public void gmailSaveAndSendTest(String email, String password) {
		WebDriver chromeDriver = DriverPool.getThreadDriver();
		LoginBO loginBO = new LoginBO(chromeDriver, pageUpdateTimeOut);
		loginBO.logIn(email, password);
		GmailMessageBO gmailMessageBO = new GmailMessageBO(chromeDriver, pageUpdateTimeOut);
		gmailMessageBO.writeEmailAndSave(message);
		gmailMessageBO.openDraftAndSend(message);
		Assert.assertTrue(gmailMessageBO.isEmailSendingSuccessful());
	}

	@AfterMethod
	public void quitDriver() {
		DriverPool.quitDriver();
	}
}
