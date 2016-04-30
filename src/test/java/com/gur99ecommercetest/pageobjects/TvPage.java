package com.gur99ecommercetest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.guru99ecommercetest.util.WebUtil;

public class TvPage {
	
	@FindBy(how=How.CSS,using="a[title='LG LCD']+div a.link-wishlist") 
	WebElement wishListLink;
	
	public MyWishListPage clickAddWishList(WebDriver driver) {
		
		WebUtil.click(wishListLink);
		
		return PageFactory.initElements(driver, MyWishListPage.class);
	}

}
