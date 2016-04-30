package com.gur99ecommercetest.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.guru99ecommercetest.util.WebUtil;

public class CompareProductsWindow {
	
	@FindBy(how=How.CSS,using=".page-title.title-buttons>h1")
	WebElement title;
	@FindBy(how=How.CSS,using="h2>a[title='Sony Xperia']")
	WebElement sony;
	@FindBy(how=How.CSS,using="h2>a[title='IPhone']")
	WebElement iphone;

	public String verifyPopUpWindow(WebDriver driver) {
		
		return WebUtil.getElementText(title);
	
		
	}

	public String getProduct1(WebDriver driver) {
		
		return WebUtil.getElementText(sony);
		
		
	}

	public String getProduct2(WebDriver driver) {
		
		return WebUtil.getElementText(iphone);
		
	}

	public void closePopUpWindow(WebDriver driver, String parentWindow) {
		
		driver.close();
		driver.switchTo().window(parentWindow);
		
	}

}
