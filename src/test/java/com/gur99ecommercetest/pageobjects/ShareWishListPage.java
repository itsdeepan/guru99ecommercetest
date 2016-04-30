package com.gur99ecommercetest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.guru99ecommercetest.util.WebUtil;

public class ShareWishListPage {

	@FindBy(how=How.CSS,using="#email_address")
	WebElement emailElement;
	@FindBy(how=How.CSS,using="#message")
	WebElement messageElement;
	
	public void fillEmailAndMessage(WebDriver driver) {
		String emails = "ppp@ggg.com";
		String msg = "Teting";
		WebUtil.clearAndSendKeys(emailElement, emails);
		WebUtil.clearAndSendKeys(messageElement, msg);
		
	}

	public void clickShareWishListButton(WebDriver driver) {
		
		WebUtil.click(driver, By.cssSelector("button[title='Share Wishlist']"));
	}

}
