package com.guru99ecommercetest.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gur99ecommercetest.pageobjects.HomePage;

public class WebUtil {

	private static final long WAIT_TIME = 30;

	public static HomePage loadPage(WebDriver driver, String base_url) {
		
		driver.manage().window().maximize();	 
		driver.get(base_url);
		return PageFactory.initElements(driver, HomePage.class);
	}
	
public static HomePage loadAdminPage(WebDriver driver, String url) {
		
		driver.get(url);
		driver.manage().window().maximize();
		return PageFactory.initElements(driver, HomePage.class);
	}

	public static void click(WebDriver driver, By by) {
		
		WebElement element = driver.findElement(by);
		element.click();
		
	}
	public static void click(WebElement element) {
		
		element.click();
		
	}

	

	public static void waitForElementVisibility(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	
	public static void selectDropDownMenu(WebElement element, String string) {
		
		Select dropList = new Select(element);
		dropList.selectByVisibleText(string);
		
	}

	public static boolean isSorted(List<WebElement> elements) {
		
		boolean sorted = true;
		
		List<WebElement> list = elements;
		
		for(int i=1; i<list.size();i++){
			
			if((list.get(i-1).getText()).compareTo(list.get(i).getText()) > 0 )
				sorted = false;
			
		}
		
		return sorted;
	}

	public static String getElementText(WebElement element) {
		
		return element.getText();
	}

	public static void clearAndSendKeys(WebElement element, String keys) {
		
		element.clear();
		element.sendKeys(keys);
		
	}

	public static void takesScreenShot(WebDriver driver,String imgPath) {
		
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(imgPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

//	public static void selectDropDownList(WebElement element,String value) {
//		Select dropList = new Select(element);
//		dropList.selectByVisibleText(value);
//		
//	}

	public static void submit(WebElement element) {
		
		element.submit();
		
	}

	


}
