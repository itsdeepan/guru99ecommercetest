package com.gur99ecommercetest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.guru99ecommercetest.util.WebUtil;

public class CreateAccountPage {
	
	@FindBy(how=How.CSS,using=".page-title>h1")
	WebElement elementTitle;
	@FindBy(how=How.CSS,using="#firstname")
	WebElement elementFirstname;
	@FindBy(how=How.CSS,using="#lastname")
	WebElement elementLastname;
	@FindBy(how=How.CSS,using="#email_address")
	WebElement elementEmail_address;
	@FindBy(how=How.CSS,using="#password")
	WebElement elementPassword;
	@FindBy(how=How.CSS,using="#confirmation")
	WebElement elementCpassword;
	
	public void fillAccountInformation(WebDriver driver,String fName, String lName, String email, String password, String cPassword) {
		
		WebUtil.waitForElementVisibility(driver,elementTitle);
		
		WebUtil.clearAndSendKeys(elementFirstname,fName);
		WebUtil.clearAndSendKeys(elementLastname,lName);
		WebUtil.clearAndSendKeys(elementEmail_address,email);
		WebUtil.clearAndSendKeys(elementPassword,password);
		WebUtil.clearAndSendKeys(elementCpassword,cPassword);
		
		
	}
	
	@FindBy(how=How.CSS,using="button[title='Register']")
	WebElement registerBtn;
	public CustomerAccountPage clickRegisterButton(WebDriver driver) {
		
		WebUtil.click(registerBtn);
		return PageFactory.initElements(driver, CustomerAccountPage.class);
		
	}

}
