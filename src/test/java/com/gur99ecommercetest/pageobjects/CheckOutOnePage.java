package com.gur99ecommercetest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.guru99ecommercetest.util.WebUtil;

public class CheckOutOnePage {
	
	@FindBy(how=How.CSS,using="#p_method_checkmo")
	WebElement payment; 
	@FindBy(how=How.CSS,using=".button[onclick*='payment']")
	WebElement continuePaymentBtn;
	public void selectMoneyOrderAndContinue(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver, payment);
		WebUtil.click(payment);
		WebUtil.click(continuePaymentBtn);
		
		
	}
	
	@FindBy(how=How.CSS,using=".button.btn-checkout")
	WebElement placeOrder;
	public CheckOutSuccessPage clickPlaceOrder(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver, placeOrder);
		WebUtil.click(placeOrder);
		return PageFactory.initElements(driver, CheckOutSuccessPage.class);
		
	}
	
	@FindBy(how=How.CSS,using=".button[type='button'][onclick*='shippingMethod']")
	WebElement continueBtn;
	public void confirmShippingMethod(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver, continueBtn);
		WebUtil.click(continueBtn);
		
		
	}
	
	@FindBy(how=How.CSS,using=".button[title='Continue']")
	WebElement shippingConfirmation;
	public void confirmShippingAddress(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver, shippingConfirmation);
		WebUtil.click(shippingConfirmation);
		
	}
	
	@FindBy(how=How.CSS,using="input[id='billing:street1']")
	WebElement addressElement;
	@FindBy(how=How.CSS,using="input[id='billing:city']")
	WebElement cityElement;
	@FindBy(how=How.CSS,using="select[id='billing:region_id']")
	WebElement stateElement;
	@FindBy(how=How.CSS,using="input[id='billing:postcode']")
	WebElement zipElement;
	@FindBy(how=How.CSS,using="select[id='billing:country_id']")
	WebElement countrElement;
	@FindBy(how=How.CSS,using="input[id='billing:telephone']")
	WebElement telElement;
	@FindBy(how=How.CSS,using=".button[title='Continue']")
	WebElement continueBtn2;
	
	public void fillBillingInfoForNewCustomerAndContinue(WebDriver driver, String address, String city, String state,
			String zip, String country, String tel) {
		WebUtil.waitForElementVisibility(driver, addressElement);
		WebUtil.clearAndSendKeys(addressElement, address);
		WebUtil.clearAndSendKeys(cityElement, city);
		WebUtil.selectDropDownMenu(stateElement,state);
		WebUtil.clearAndSendKeys(zipElement, zip);
		WebUtil.selectDropDownMenu(countrElement,country);
		WebUtil.clearAndSendKeys(telElement, tel);
		WebUtil.click(continueBtn2);
		
	}

}
