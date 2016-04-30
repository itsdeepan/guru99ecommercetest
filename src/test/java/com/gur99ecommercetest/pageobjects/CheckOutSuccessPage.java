package com.gur99ecommercetest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.guru99ecommercetest.util.WebUtil;

public class CheckOutSuccessPage {
	
	@FindBy(how=How.XPATH,using="//h1[text()='Your order has been received.']")
	WebElement orderConfirmation;
	public String getOrderConfirmationMessage(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver, orderConfirmation);
		return WebUtil.getElementText(orderConfirmation);
		
	}
	
	@FindBy(how=How.CSS,using="h2.sub-title+p>a")
	WebElement orderNo;
	public String getOrderNo(WebDriver driver) {
		WebUtil.waitForElementVisibility(driver, orderNo);
		return WebUtil.getElementText(orderNo);
		
	}

}
