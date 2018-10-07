package com.epam.lab.DDTHomeWork.pageElements;

import org.openqa.selenium.WebElement;

public class DivTextInput extends Element {

	public DivTextInput(WebElement webElement) {
		super(webElement);
	}

	public void type(String text) {
		if(webElement.isEnabled()){
			super.clear();
		}
		super.sendKeys(text);
	}
}
