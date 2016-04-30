package com.gur99ecommercetest.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.guru99ecommercetest.util.WebUtil;

public class LoginAccountPage {
	
	@FindBy(how=How.CSS,using="a[title='Create an Account']") 
	WebElement createAccountBtn;
	
	public CreateAccountPage clickCreateAccountButton(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver,createAccountBtn);
		WebUtil.click(createAccountBtn);
		return PageFactory.initElements(driver, CreateAccountPage.class);
	}

	@FindBy(how=How.CSS,using="#email")
	WebElement email;
	@FindBy(how=How.CSS,using="#pass")
	WebElement password;
	@FindBy(how=How.CSS,using="#send2")
	WebElement login;
	public CustomerAccountPage fillLoginDetails(WebDriver driver,String email_id, String pass) {
		WebUtil.waitForElementVisibility(driver,email);
		WebUtil.clearAndSendKeys(email, email_id);
		WebUtil.clearAndSendKeys(password, pass);
		WebUtil.click(login);
		return PageFactory.initElements(driver,CustomerAccountPage.class);
	}

}
