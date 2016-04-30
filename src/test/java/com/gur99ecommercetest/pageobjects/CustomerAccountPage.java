package com.gur99ecommercetest.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.guru99ecommercetest.util.WebUtil;

public class CustomerAccountPage {
	
	@FindBy(how=How.CSS,using="a[href$='tv.html']")
	WebElement tvMenu;
	
	public TvPage clickTvMenu(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver,tvMenu);
		WebUtil.click(tvMenu);
		return PageFactory.initElements(driver, TvPage.class);
	}
	
	@FindBy(how=How.CSS,using="p.welcome-msg")
	WebElement welcomeMsg;
	public String getWelcomeNewAccountMessage() {
		
		return WebUtil.getElementText(welcomeMsg);
	}
	
	@FindBy(how=How.CSS,using="li+li+li>a[href*='wishlist']")
	WebElement wishList;
	public MyWishListPage clickMyWishListLink(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver, wishList);
		WebUtil.click(wishList);
		return PageFactory.initElements(driver, MyWishListPage.class);
	}
	
	@FindBy(how=How.CSS,using=".link-reorder")
	WebElement reoderLink;
	public CheckOutCartPage clickReorderLink(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver, reoderLink);
		WebUtil.click(reoderLink);
		return PageFactory.initElements(driver, CheckOutCartPage.class);
	}
	
	

}
