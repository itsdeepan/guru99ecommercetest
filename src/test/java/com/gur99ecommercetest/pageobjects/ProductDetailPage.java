package com.gur99ecommercetest.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.guru99ecommercetest.util.WebUtil;

public class ProductDetailPage {

	@FindBy(how=How.XPATH,using="//*[@id='product-price-1']/span")
	WebElement price;
	
	public String getXperiaProductDetailPrice(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver, price);
		return WebUtil.getElementText(price);
		
		
	}

}
