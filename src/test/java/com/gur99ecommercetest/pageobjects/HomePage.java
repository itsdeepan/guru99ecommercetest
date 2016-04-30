package com.gur99ecommercetest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.guru99ecommercetest.util.WebUtil;

public class HomePage {
	
	@FindBy(how=How.CSS,using=".page-title>h2")
	WebElement pageTitle;
	
	public String getPageTitle(WebDriver driver) {
		
		return WebUtil.getElementText(pageTitle);
		
	}
	
	@FindBy(how=How.CSS,using="a[class^='level0'][href$='mobile.html']")
	WebElement mobileMenu;
	public MobilePage clickOnMobileMenu(WebDriver driver) {
		
//		WebUtil.waitForElementVisibility(driver,By.cssSelector("a[class^='level0'][href$='mobile.html']"));
		
		WebUtil.waitForElementVisibility(driver,mobileMenu);
		
		WebUtil.click(mobileMenu);
		
		return PageFactory.initElements(driver, MobilePage.class);
		
	}
	
	@FindBy(how=How.CSS,using="div[class='block-title']+ul>li>a[title='My Account")
	WebElement myAccountLink;
	public LoginAccountPage clickMyAccountLinkage(WebDriver driver) {
		
		WebUtil.click(myAccountLink);
		return PageFactory.initElements(driver, LoginAccountPage.class);
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='username']")
	WebElement loginNameInput;
	@FindBy(how=How.XPATH,using=".//*[@id='login']")
	WebElement passwordInput;
	@FindBy(how=How.XPATH,using="//input[@title='Login']")
	WebElement loginBtn;
	@FindBy(how=How.XPATH,using="//h3[@class='icon-head head-customer']")
	WebElement customerTitle;
	public ManageCustomerPage loginToAdminPanel(WebDriver driver, String userName, String password) {
	
		WebUtil.waitForElementVisibility(driver, loginNameInput);
		WebUtil.clearAndSendKeys(loginNameInput, userName);
		WebUtil.clearAndSendKeys(passwordInput, password);
		WebUtil.click(loginBtn);
		
		WebUtil.waitForElementVisibility(driver, customerTitle);
		
		driver.navigate().refresh();
		
		
		
		return PageFactory.initElements(driver, ManageCustomerPage.class);
		
	}
	
	
	
	

}
