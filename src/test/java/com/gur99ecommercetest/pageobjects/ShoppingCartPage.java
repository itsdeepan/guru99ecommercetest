package com.gur99ecommercetest.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.guru99ecommercetest.util.WebUtil;

public class ShoppingCartPage {
	
	@FindBy(how=How.CSS,using="input[title='Qty']")
	WebElement inputQty;
	@FindBy(how=How.CSS,using=".button.btn-update")
	WebElement updateBtn;
	@FindBy(how=How.CSS,using=".item-msg.error")
	WebElement errorMsg;

	public String changeQty(WebDriver driver,String qty) {
		
		WebUtil.waitForElementVisibility(driver, inputQty);
		WebUtil.clearAndSendKeys(inputQty,qty);
		WebUtil.click(updateBtn);
		WebUtil.waitForElementVisibility(driver, errorMsg);
		return WebUtil.getElementText(errorMsg);
		
		
	}

	@FindBy(how=How.CSS,using="#empty_cart_button")
	WebElement emptyCart;
	@FindBy(how=How.CSS,using=".page-title>h1")
	WebElement pageTitle;
	
	public String clickEmptyCartButton(WebDriver driver) {
		
		WebUtil.click(emptyCart);
		return WebUtil.getElementText(pageTitle);
		
		
	}

}
