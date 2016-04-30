package com.gur99ecommercetest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ManageCustomerPage {
	
	@FindBy(how=How.XPATH,using=".//*[@class='nav-bar']/ul/li[1]")
	WebElement sales;
	@FindBy(how=How.XPATH,using=".//*[contains(@href,'sales_order')]")
	WebElement order;
	public SalesOrderPage openSalesOrderPage(WebDriver driver) {
		
		Actions action = new Actions(driver);
		action.moveToElement(sales);
		action.moveToElement(order).click();
		action.perform();
		
		return PageFactory.initElements(driver, SalesOrderPage.class);
	}

}
