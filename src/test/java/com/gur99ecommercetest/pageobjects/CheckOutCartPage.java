package com.gur99ecommercetest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.guru99ecommercetest.util.WebUtil;

public class CheckOutCartPage {
	
	@FindBy(how=How.CSS,using="li.method-checkout-cart-methods-onepage-bottom>button.btn-proceed-checkout.btn-checkout")
	WebElement checkout;
	public CheckOutOnePage proceedCheckOut(WebDriver driver) {
		WebUtil.waitForElementVisibility(driver, checkout);
		WebUtil.click(checkout);
		return PageFactory.initElements(driver, CheckOutOnePage.class);
	}
	
	@FindBy(how=How.CSS,using="#country")
	WebElement countryElement;
	@FindBy(how=How.CSS,using="#region_id")
	WebElement regionElement;
	@FindBy(how=How.CSS,using="#postcode")
	WebElement postcodeElement;
	
	public void enterShippingInfo(WebDriver driver,String country,String state, String zip) {

		WebUtil.waitForElementVisibility(driver, countryElement);
		WebUtil.selectDropDownMenu(countryElement,country);
		WebUtil.selectDropDownMenu(regionElement,state);
		WebUtil.clearAndSendKeys(postcodeElement,zip);
		
		
		
	}
	
	@FindBy(how=How.CSS,using=".button2[title='Estimate']")
	WebElement estimate;
	public void clickEstimateLink(WebDriver driver) {
		WebUtil.waitForElementVisibility(driver, estimate);
		WebUtil.click(estimate);
		
	}
	
	@FindBy(how=How.CSS,using="input#s_method_flatrate_flatrate+label>span")
	WebElement flatRate;
	public String getShippingCost(WebDriver driver) {
		WebUtil.waitForElementVisibility(driver, flatRate);
		return WebUtil.getElementText(flatRate);
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='co-shipping-method-form']/div/button']")
	WebElement updateTotal;
	public void clickUpdateTotal(WebDriver driver) {
		
		
		WebUtil.waitForElementVisibility(driver, updateTotal);
		WebUtil.submit(updateTotal);
		
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/span")
	WebElement subTotal;
	public String getSubTotal(WebDriver driver) {
		WebUtil.waitForElementVisibility(driver, subTotal);
		return WebUtil.getElementText(subTotal);
	}
	
	@FindBy(how=How.XPATH,using="//table[@id='shopping-cart-totals-table']//strong/span[@class='price']")
	WebElement grandTotal;
	public String getGrandTotal(WebDriver driver) {
		WebUtil.waitForElementVisibility(driver,grandTotal);
		return WebUtil.getElementText(grandTotal);
	}
	
	@FindBy(how=How.CSS,using="#s_method_flatrate_flatrate")
	WebElement shippingCost;
	@FindBy(how=How.CSS,using=".button[value='Update Total']")
	WebElement updateTotalBtn;
	public void selectShippingCostAndUpdateTotal(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver, shippingCost);
		WebUtil.click(shippingCost);
		
		WebUtil.waitForElementVisibility(driver, updateTotalBtn);
		WebUtil.click(updateTotalBtn);
		
	}
	
	@FindBy(how=How.CSS,using=".input-text.qty[title='Qty']")
	WebElement changeQtyText;
	@FindBy(how=How.CSS,using=".button.btn-update")
	WebElement updateBtn;
	public void changeQtyAndClickUpdate(WebDriver driver,String changeQtyNo) {
		
	WebUtil.waitForElementVisibility(driver, changeQtyText);
	WebUtil.clearAndSendKeys(changeQtyText,changeQtyNo);
	WebUtil.click(changeQtyText);
	WebUtil.waitForElementVisibility(driver, updateBtn);
	WebUtil.click(updateBtn);
		
	}
	
	@FindBy(how=How.CSS,using="#billing-address-select")
	WebElement billingAddressDropDownMenu;
	@FindBy(how=How.CSS,using="div#billing-buttons-container>button.button[title='Continue']")
	WebElement continueBtn;
	public void selectBillingInfoForExistingCustomerAndContinue(WebDriver driver,String address) {
		
		WebUtil.waitForElementVisibility(driver, billingAddressDropDownMenu);
//		WebUtil.selectDropDownMenu(billingAddressDropDownMenu, address);
		WebUtil.click(continueBtn);
		
	}
	
	@FindBy(how=How.CSS,using="div#shipping-method-buttons-container>button.button[type='button']")
	WebElement shippingMethodContinueBtn;
	public void clickShippingMethodContinue(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver, shippingMethodContinueBtn);
		WebUtil.click(shippingMethodContinueBtn);
		
	}
	
	@FindBy(how=How.CSS,using="#checkout-payment-method-load>dt>input#p_method_checkmo")
	WebElement moneyOrderRadioBtn;
	@FindBy(how=How.CSS,using="div#payment-buttons-container>button.button")
	WebElement paymentContinueBtn;
	public void selectPaymentInfoAndContinue(WebDriver driver) {
		WebUtil.waitForElementVisibility(driver, moneyOrderRadioBtn);
		WebUtil.click(moneyOrderRadioBtn);
		WebUtil.click(paymentContinueBtn);
		
		
	}
	
	@FindBy(how=How.CSS,using=".button.btn-checkout")
	WebElement placeOrderBtn;
	public CheckOutSuccessPage clickPlaceOrder(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver,placeOrderBtn);
		WebUtil.click(placeOrderBtn);
		return PageFactory.initElements(driver, CheckOutSuccessPage.class);
		
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='coupon_code']")
	WebElement dicountCode;
	@FindBy(how=How.XPATH,using="//button[@title='Apply']")
	WebElement apply;
	public void applyDiscountCode(WebDriver driver, String disc ) {
		
		WebUtil.waitForElementVisibility(driver, dicountCode);
		WebUtil.clearAndSendKeys(dicountCode, disc);
		WebUtil.click(apply);
	}
	
	@FindBy(how=How.XPATH,using="//td[contains(text(),'Discount')]/following::span[@class='price']")
	WebElement discount;
	public String getActualDiscount(WebDriver driver) {
		
		WebUtil.waitForElementVisibility(driver, discount);
		return WebUtil.getElementText(discount);
	}
	
	
//	@FindBy(how=How.CSS,using="input[id='billing:street1']")
//	WebElement addressElement;
//	@FindBy(how=How.CSS,using="input[id='billing:city']")
//	WebElement cityElement;
//	@FindBy(how=How.CSS,using="select[id='billing:region_id']")
//	WebElement stateElement;
//	@FindBy(how=How.CSS,using="input[id='billing:postcode']")
//	WebElement zipElement;
//	@FindBy(how=How.CSS,using="select[id='billing:country_id']")
//	WebElement countrElement;
//	@FindBy(how=How.CSS,using="input[id='billing:telephone']")
//	WebElement telElement;
//	@FindBy(how=How.CSS,using=".button[title='Continue']")
//	WebElement continueBtn;
//	
//	public CheckOutOnePage fillBillingInfoAndContinue(WebDriver driver, String address, String city, String state,
//			String zip, String country, String tel) {
//		WebUtil.waitForElementVisibility(driver, addressElement);
//		WebUtil.clearAndSendKeys(addressElement, address);
//		WebUtil.clearAndSendKeys(cityElement, city);
//		WebUtil.selectDropDownList(stateElement,state);
//		WebUtil.clearAndSendKeys(zipElement, zip);
//		WebUtil.selectDropDownList(countrElement,country);
//		WebUtil.clearAndSendKeys(telElement, tel);
//		WebUtil.click(continueBtn);
//		return PageFactory.initElements(driver, CheckOutOnePage.class);
//	}
	
	
	
	

}
