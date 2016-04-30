package com.gur99ecommercetest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.guru99ecommercetest.util.WebUtil;

public class SalesOrderPage {
	
	@FindBy(how=How.XPATH,using=".//*[@id='sales_order_grid_export']")
	WebElement salesOrder;
	@FindBy(how=How.XPATH,using="//button[@title='Export']")
	WebElement exportBtn;
	public void selectCSVFileAndExport(WebDriver driver, String fileType) {
		
		
		WebUtil.waitForElementVisibility(driver, salesOrder);
		WebUtil.selectDropDownMenu(salesOrder, fileType);
		WebUtil.click(exportBtn);
		
		for(String windowId : driver.getWindowHandles()){
			System.out.println(driver.switchTo().window(windowId).getTitle());
			
		}
		
	}

}
