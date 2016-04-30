package com.gur99ecommercetest.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.guru99ecommercetest.util.WebUtil;

public class MyWishListPage {
	
	@FindBy(how=How.CSS,using=".button.btn-share")
	WebElement shareBtn;
	public ShareWishListPage clickShareWishList(WebDriver driver) {

		WebUtil.waitForElementVisibility(driver,shareBtn);
		WebUtil.click(shareBtn);
		return PageFactory.initElements(driver, ShareWishListPage.class);
	}
	
	@FindBy(how=How.CSS,using=".button.btn-cart")
	WebElement addToCart;
	public CheckOutCartPage addToCart(WebDriver driver) {
		WebUtil.waitForElementVisibility(driver, addToCart);
		WebUtil.click(addToCart);
		return PageFactory.initElements(driver, CheckOutCartPage.class);
	}

}
