package com.gur99ecommercetest.pageobjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.guru99ecommercetest.util.WebUtil;

public class MobilePage {
	
	public String getMobilePageHeader(WebDriver driver) {
		return driver.getTitle();
		
	}
	
	@FindBy(how=How.CSS,using="select[title='Sort By']")
	WebElement dropDownMenu;

	public void selectSortByName(WebDriver driver) {
		
		WebUtil.selectDropDownMenu(dropDownMenu,"Name");
		
		
	}
	
	@FindBys(@FindBy(how=How.CSS,using="h2.product-name>a"))
	List<WebElement> elements;
	
	public boolean verifyProductsSorted(WebDriver driver) {
		
		return WebUtil.isSorted(elements);
		
		
	}
	
	@FindBy(how=How.CSS,using="span[id='product-price-1']>span")
	WebElement mobilePrice;

	public String getXperiaMobilePrice(WebDriver driver) {
		
		return WebUtil.getElementText(mobilePrice);
		
		
	}
	
	@FindBy(how=How.CSS,using="#product-collection-image-1")
	WebElement mobileLink;
	
	public ProductDetailPage clickMobieLink(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver,mobileLink);
		WebUtil.click(mobileLink);
		
		return PageFactory.initElements(driver, ProductDetailPage.class);
	}
	
	@FindBy(how=How.CSS,using="a[title='Xperia']+div>div[class='actions']>button")
	WebElement addToCartBtn;

	public ShoppingCartPage clickAddToCartButton(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver,addToCartBtn);
		WebUtil.click(addToCartBtn);
		
		return PageFactory.initElements(driver, ShoppingCartPage.class);
		
	}
	
	@FindBy(how=How.CSS,using="a[title='Xperia']+div>div[class='actions']>ul>li>a[class='link-compare']")
	WebElement xperia;
	@FindBy(how=How.CSS,using="a[title='IPhone']+div>div[class='actions']>ul>li>a[class='link-compare']")
	WebElement iphone;

	public void clickAddToCompareLinkage(WebDriver driver) {
		
		WebUtil.click(xperia);
		WebUtil.waitForElementVisibility(driver,xperia);
		WebUtil.click(iphone);
		
		
	}
	
	@FindBy(how=How.CSS,using="button[title='Compare']")
	WebElement compareBtn;

	public CompareProductsWindow clickCompareButton(WebDriver driver) {
	
		WebUtil.waitForElementVisibility(driver,compareBtn);
		WebUtil.click(compareBtn);
		
		for(String windowHandle:driver.getWindowHandles()){
			driver.switchTo().window(windowHandle);
		}
		return PageFactory.initElements(driver, CompareProductsWindow.class);
	}

	@FindBy(how=How.XPATH,using="//li[@class='item last'][1]//button[@title='Add to Cart']")
	WebElement addToCart;
	public CheckOutCartPage addIphoneToCart(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver, addToCart);
		WebUtil.click(addToCart);
		
		return PageFactory.initElements(driver, CheckOutCartPage.class);
	}

	

}
