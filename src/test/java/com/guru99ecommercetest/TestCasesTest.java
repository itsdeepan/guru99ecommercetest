package com.guru99ecommercetest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Random;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gur99ecommercetest.pageobjects.CheckOutCartPage;
import com.gur99ecommercetest.pageobjects.CheckOutOnePage;
import com.gur99ecommercetest.pageobjects.CheckOutSuccessPage;
import com.gur99ecommercetest.pageobjects.CompareProductsWindow;
import com.gur99ecommercetest.pageobjects.CreateAccountPage;
import com.gur99ecommercetest.pageobjects.CustomerAccountPage;
import com.gur99ecommercetest.pageobjects.HomePage;
import com.gur99ecommercetest.pageobjects.LoginAccountPage;
import com.gur99ecommercetest.pageobjects.ManageCustomerPage;
import com.gur99ecommercetest.pageobjects.MobilePage;
import com.gur99ecommercetest.pageobjects.MyWishListPage;
import com.gur99ecommercetest.pageobjects.ProductDetailPage;
import com.gur99ecommercetest.pageobjects.SalesOrderPage;
import com.gur99ecommercetest.pageobjects.ShareWishListPage;
import com.gur99ecommercetest.pageobjects.ShoppingCartPage;
import com.gur99ecommercetest.pageobjects.TvPage;
import com.guru99ecommercetest.util.WebUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestCasesTest {

	ExtentReports extent;
	ExtentTest test;

	Logger logger;

	private WebDriver driver;
	private String BASE_URL = "http://live.guru99.com/";
	private String QTY = "1000";

	private String email;
	private String password;

	@BeforeTest
	public void initialize() {

		extent = new ExtentReports(
				"/Users/itsdeepan/Documents/Selenium/Selenium WebDriver/workspace/guru99ecommerce/Reports/report.html");

		logger = Logger.getLogger(TestCasesTest.class.getName());
		PropertyConfigurator.configure("log4j.properties");
	}

	@Test
	public void TestCase01() {
		String actualPageTitle;
		String expectedPageTitle = "THIS IS DEMO SITE FOR";
		String expectedMobileTitle = "Mobile";
		String actualMobileTitle;

		driver = new FirefoxDriver();

		// 1. Go to http://live.guru99.com/
		HomePage homePage = WebUtil.loadPage(driver, BASE_URL);

		System.out.println("Test Case01 : Verify Title of Home Page.");

		// 2. Verify title of the page
		actualPageTitle = homePage.getPageTitle(driver);
		actualPageTitle = actualPageTitle.trim();

		// Assert.assertTrue(actualPageTitle.equals(expectedPageTitle), "wrong
		// title");

		try {
			AssertJUnit.assertEquals(actualPageTitle, expectedPageTitle);
		} catch (AssertionError e) {
			System.out.println("Wrong Title of the page!");
		}
		System.out.println("Expected Page Title: " + expectedPageTitle);
		System.out.println("Actual Page Title: " + actualPageTitle);

		WebUtil.takesScreenShot(driver, "screenshots/TestCase01-VerifyTilte.png");

		System.out.println("Test Case01 : Verify Title of Mobile Page.");

		// 3. Click on 'Mobile' menu
		MobilePage mobilePage = homePage.clickOnMobileMenu(driver);

		// 4. Verify title of the 'Mobile' page
		actualMobileTitle = mobilePage.getMobilePageHeader(driver);
		AssertJUnit.assertEquals(actualMobileTitle, expectedMobileTitle);

		WebUtil.takesScreenShot(driver, "screenshots/TestCase01-VerifyMobilePageTile.png");

		System.out.println("Expected Mobile Title: " + expectedMobileTitle);
		System.out.println("Actual Mobile Title: " + actualMobileTitle);

		// 5. Select 'Sort by' drop down as 'name'
		mobilePage.selectSortByName(driver);

		// 6. Verify all products are sorted by name
		System.out.println("Test Case01 : Verify all products are sorted by name.");
		// AssertJUnit.assertTrue(mobilePage.verifyProductsSorted(driver),"All
		// products should be sorted by name !");

		WebUtil.takesScreenShot(driver, "screenshots/TestCase01-VerifyProductsSorted.png");
	}

	@Test
	public void TestCase02() {

		driver = new FirefoxDriver();

		// 1. Go to http://live.guru99.com/
		HomePage homePage = WebUtil.loadPage(driver, BASE_URL);

		// 2. Click on 'Mobile' menu
		MobilePage mobilePage = homePage.clickOnMobileMenu(driver);

		// 3. Read the cost of Sony Xperia mobile
		String xperiaMobilePrice = mobilePage.getXperiaMobilePrice(driver);

		// 4. Click on Sony Xperia mobile
		ProductDetailPage productDetailPage = mobilePage.clickMobieLink(driver);

		// 5. Read the cost of Sony Xperia mobile dretail page
		String xperiaProductDetailPrice = productDetailPage.getXperiaProductDetailPrice(driver);

		System.out.println("Xperia Mobile List Price :" + xperiaMobilePrice);
		System.out.println("Xperia Product Detail Price :" + xperiaProductDetailPrice);

		// 6. Compare the two cost
		try {
			AssertJUnit.assertEquals(xperiaMobilePrice, xperiaProductDetailPrice);
			// Assert.assertTrue((xperiaProductDetailPrice.equals(xperiaMobilePrice)),"Product
			// value in list and detail page should be equal!");
		} catch (AssertionError e) {
			System.out.println(e);
		}
	}

	@Test
	public void TestCase03() {

		String expectedErrorMessage = "* The maximum quantity allowed for purchase is 500.";
		String emptyCartMsg = "SHOPPING CART IS EMPTY";

		driver = new FirefoxDriver();

		// 1.Go to "http://live.guru99.com"
		HomePage homePage = WebUtil.loadPage(driver, BASE_URL);

		// 2.Click on 'Mobile' menu
		MobilePage mobilePage = homePage.clickOnMobileMenu(driver);

		// 3.Click on 'Add to Cart' for Sony Xperia mobile
		ShoppingCartPage shoppingCartPage = mobilePage.clickAddToCartButton(driver);

		// 4.Change 'QTY' value to 1000 and click 'Update' button
		String actualErrorMessage = shoppingCartPage.changeQty(driver, QTY);

		// 5.Verify the error message
		AssertJUnit.assertEquals(actualErrorMessage.trim(), expectedErrorMessage);

		// 6.Then click on 'Empty cart' link in the footer of list of all
		// mobiles
		String emptytMsg = shoppingCartPage.clickEmptyCartButton(driver);

		// 7.Verify cart is empty
		AssertJUnit.assertEquals(emptyCartMsg, emptytMsg);
	}

	@Test
	public void TestCase04() throws Exception {

		String product1 = "SONY XPERIA";
		String product2 = "IPHONE";
		String expectedPopUpWindowTitle = "COMPARE PRODUCTS";

		driver = new FirefoxDriver();

		// 1. Go to http://live.guru99.com
		HomePage homePage = WebUtil.loadPage(driver, BASE_URL);

		// 2. Click on 'Mobile' menu
		MobilePage mobilePage = homePage.clickOnMobileMenu(driver);

		// 3. Click on 'Add to compare' for 2 mobiles
		mobilePage.clickAddToCompareLinkage(driver);

		String parentWindow = driver.getWindowHandle();

		// 4. Click on 'Compare' button
		CompareProductsWindow compareProductsWindow = mobilePage.clickCompareButton(driver);

		// 5. Verify the pop-up window and check that the products are reflected
		// in it
		String actualPopUpWindowTitle = compareProductsWindow.verifyPopUpWindow(driver);
		AssertJUnit.assertEquals(actualPopUpWindowTitle, expectedPopUpWindowTitle);

		String actualProduct1 = compareProductsWindow.getProduct1(driver);
		String actualProduct2 = compareProductsWindow.getProduct2(driver);

		AssertJUnit.assertEquals(actualProduct1, product1);
		AssertJUnit.assertEquals(actualProduct2, product2);

		// 6. Close the popup windows
		compareProductsWindow.closePopUpWindow(driver, parentWindow);
		Thread.sleep(5000);

	}

	@Test
	public void TestCase05() throws Exception {

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt();

		String fName = "NEIL";
		String lName = "BUTLER";
		email = "neil" + randomInt + "@mail.com";
		password = "password1";
		String cPassword = "password1";

		driver = new FirefoxDriver();

		// 1. Go to http://live.guru99.com/
		HomePage homePage = WebUtil.loadPage(driver, BASE_URL);

		// 2. Click on my account link
		LoginAccountPage loginAccountPage = homePage.clickMyAccountLinkage(driver);

		// 3. Click create account link and new user information except email id
		CreateAccountPage createAccountPage = loginAccountPage.clickCreateAccountButton(driver);
		createAccountPage.fillAccountInformation(driver, fName, lName, email, password, cPassword);

		// 4. click register
		CustomerAccountPage newAccountPage = createAccountPage.clickRegisterButton(driver);

		// 5. verify registration is done
		String actualWelcomeNewAccountMessage = newAccountPage.getWelcomeNewAccountMessage();
		String expectedWelcomeNewAccountMessage = "WELCOME, " + fName + " " + lName + "!";

		AssertJUnit.assertEquals(actualWelcomeNewAccountMessage, expectedWelcomeNewAccountMessage);

		WebUtil.takesScreenShot(driver, "screenshots/AcctRegistrationDetails.png");

		// 6. Go to TV menu
		TvPage tvPage = newAccountPage.clickTvMenu(driver);

		// 7. Add product in your wish list
		MyWishListPage myWishListPage = tvPage.clickAddWishList(driver);

		// 8. Click share wishlist
		ShareWishListPage shareWishListPage = myWishListPage.clickShareWishList(driver);

		// 9. In next page enter Email and a message and click share wishlist
		shareWishListPage.fillEmailAndMessage(driver);
		shareWishListPage.clickShareWishListButton(driver);

		// 10. Check whislist is shared

		WebUtil.takesScreenShot(driver, "screenshots/WishListSharedConfirmaton.png");

	}

	@Test
	public void TestCase06() throws Exception {

		// ********************************************************************************************
		/*
		 * Verify user is able to purchase product using registered email id
		 * (Use Chrome browser) Test Steps: 1. Go to http://live.guru99.com/ 2.
		 * Click on my account link 3. Login application using previously
		 * created credential 4. Click on my MY WISHLIST link 5. In next page,
		 * ADD TO CART link 6. Click proceed to checkout 7. Enter shipping
		 * information 8. Check estimates 9. Verify shipping cost generated
		 * 10.Select shipping cost, update total. 11.Verify shipping cost is
		 * added to total 12.Click 'Proceed to checkout' 13.Enter Billing
		 * information 14.In shipping method, click continue 15.In payment
		 * information select 'Check money order' radio button. Click continue
		 * 16.Click place order button 17.Verify order is generated. Note the
		 * order number.
		 */
		// ********************************************************************************************

		// System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver
		// 2");
		// driver = new ChromeDriver();

		driver = new FirefoxDriver();

		String address = "46 Susan Drive";
		String city = "New Jerssy";
		String state = "New York";
		String zip = "54376";
		String country = "United States";
		String tel = "0019873224";

		// String expectedOderConfirmationMsg = "YOUR ORDER HAS BEEN
		// RECEIVVED.";

		// 1. Go to http://live.guru99.com/
		HomePage homePage = WebUtil.loadPage(driver, BASE_URL);

		// 2. Click on my account link
		LoginAccountPage loginAccountPage = homePage.clickMyAccountLinkage(driver);

		// 3. Login application using previously created credential
		CustomerAccountPage customerAccountPage = loginAccountPage.fillLoginDetails(driver, email, password);

		// 4. Click on my MY WISHLIST link
		MyWishListPage myWishListPage = customerAccountPage.clickMyWishListLink(driver);

		// 5. In next page, ADD TO CART link
		CheckOutCartPage checkOutCartPage = myWishListPage.addToCart(driver);

		// 6. Click proceed to checkout
		// CheckOutBillingInfoPage checkOutBillingInfoPage =
		// checkOutPage.proceedCheckOut(driver);

		// 7. Enter shipping information
		checkOutCartPage.enterShippingInfo(driver, country, state, zip);

		// 8. Check estimates
		checkOutCartPage.clickEstimateLink(driver);

		// 9. Verify shipping cost generated
		String shippingCost = checkOutCartPage.getShippingCost(driver);

		// 10.Select shipping cost, update total.
		checkOutCartPage.selectShippingCostAndUpdateTotal(driver);

		// checkOutPage.clickUpdateTotal(driver);
		// 11.Verify shipping cost is added to total
		String subTotal = checkOutCartPage.getSubTotal(driver);
		String grandTotal = checkOutCartPage.getGrandTotal(driver);

		System.out.println("Shipping Cost :" + shippingCost);
		System.out.println("Sub Total :" + subTotal);
		System.out.println("Grand Total :" + grandTotal);

		// 12.Click 'Proceed to checkout'
		CheckOutOnePage checkOutOnePage = checkOutCartPage.proceedCheckOut(driver);

		// 13.Enter Billing information

		checkOutOnePage.fillBillingInfoForNewCustomerAndContinue(driver, address, city, state, zip, country, tel);

		// 14.In shipping method, click continue

		checkOutOnePage.confirmShippingMethod(driver);

		// 15.In payment information select 'Check money order' radio button.
		// Click continue

		checkOutOnePage.selectMoneyOrderAndContinue(driver);

		// 16.Click place order button
		CheckOutSuccessPage checkOutSuccessPage = checkOutOnePage.clickPlaceOrder(driver);

		// 17.Verify order is generated. Note the order number.

		WebUtil.takesScreenShot(driver, "screenshots/OrderConfirmation.png");

		String actualOderConfirmationMsg = checkOutSuccessPage.getOrderConfirmationMessage(driver);
		String orderNo = checkOutSuccessPage.getOrderNo(driver);

		// Assert.assertEquals(actualOderConfirmationMsg,
		// expectedOderConfirmationMsg);

		System.out.println(actualOderConfirmationMsg);
		System.out.println("Your order # is: " + orderNo);

	}

	public void TestCase07() {
		// ********************************************************************************************
		/*
		 * Verify that you will be able to save previously placed order as a pdf
		 * file Test Steps: 1. Go to http://live.guru99.com/ 2. Click on my
		 * account link 3. Login application using previously created credential
		 * 4. Click on my MY ORDER 5. Click on VIEW ORDER 6. Verify the
		 * previously created order is displayed in 'RECENT ORDERS' table and
		 * status is pendin 7. Click on 'Print Order' link 8. Verify order is
		 * saved as PDF
		 */
		// ********************************************************************************************

		// 1. Go to http://live.guru99.com/
		HomePage homePage = WebUtil.loadPage(driver, BASE_URL);

		// 2. Click on my account link
		LoginAccountPage loginAccountPage = homePage.clickMyAccountLinkage(driver);

		// 3. Login application using previously created credential
		loginAccountPage.fillLoginDetails(driver, email, password);

		// 4. Click on my MY ORDER
	}

	// ********************************************************************************************
	/*
	 * Verify you are able to change or reorder previously added product Test
	 * Steps: 1. Go to http://live.guru99.com/ 2. Click on my account link 3.
	 * Login application using previously created credential 4. Click on
	 * 'REORDER' link, change QTY & click update 5. Verify Grand Total is
	 * changed 6. Complete Billing & Shipping information 7. Verify order is
	 * generated and note the order number
	 * 
	 */
	// ********************************************************************************************

	@Test
	public void TestCase08() throws Exception {

		String expectedOderConfirmation = "YOUR ORDER HAS BEEN RECEIVED.";

		String email1 = "james@mail.com";
		String password1 = "password1";
		String changeQty = "10";
		String address = "46 susan drive";
		String country = "United States";
		String state = "New York";
		String zip = "347874";

		driver = new FirefoxDriver();

		test = extent.startTest("TestCase 08");

		// 1. Go to http://live.guru99.com/
		HomePage homePage = WebUtil.loadPage(driver, BASE_URL);
		logger.info("Open Application");
		test.log(LogStatus.INFO, "Open Application");

		// 2. Click on my account link
		LoginAccountPage loginAccountPage = homePage.clickMyAccountLinkage(driver);
		logger.info("Click Account Link");
		test.log(LogStatus.INFO, "Click Account link");

		// 3. Login application using previously created credential
		CustomerAccountPage customerAccountPage = loginAccountPage.fillLoginDetails(driver, email1, password1);
		logger.info("Login using previously created credetial");
		test.log(LogStatus.INFO, "Login using previously created credetial");

		// 4. Click on 'REORDER' link, change QTY & click update
		CheckOutCartPage checkOutCartPage = customerAccountPage.clickReorderLink(driver);
		checkOutCartPage.changeQtyAndClickUpdate(driver, changeQty);
		logger.info("click reorder link");

		// 5. Verify Grand Total is changed
		String grandTotal = checkOutCartPage.getGrandTotal(driver);

		System.out.println("Grand Total :" + grandTotal);

		// 6. Complete Billing & Shipping information
		checkOutCartPage.enterShippingInfo(driver, country, state, zip);
		checkOutCartPage.clickEstimateLink(driver);
		checkOutCartPage.selectShippingCostAndUpdateTotal(driver);
		checkOutCartPage.proceedCheckOut(driver);
		checkOutCartPage.selectBillingInfoForExistingCustomerAndContinue(driver, address);
		checkOutCartPage.clickShippingMethodContinue(driver);
		checkOutCartPage.selectPaymentInfoAndContinue(driver);
		CheckOutSuccessPage checkOutSuccessPage = checkOutCartPage.clickPlaceOrder(driver);

		logger.info("Complete Billing & Shipping information");

		// 7. Verify order is generated and note the order number
		WebUtil.takesScreenShot(driver, "screenshots/ReorderConfirmation.png");

		String actualOderConfirmation = checkOutSuccessPage.getOrderConfirmationMessage(driver);
		String orderNo = checkOutSuccessPage.getOrderNo(driver);

		AssertJUnit.assertEquals(actualOderConfirmation, expectedOderConfirmation);
		System.out.println(actualOderConfirmation);

		logger.info("Verify order is generated");

		test.log(LogStatus.INFO, "Verify order is generated");

		// Assert.assertTrue(driver.getTitle().contains(""));

		System.out.println("Your Reorder # is: " + orderNo);

		test.log(LogStatus.PASS, "Re-order is generated");

		Thread.sleep(5000);

	}

	// ********************************************************************************************
	/*
	 * Verify discount coupon works correctly Test Steps: 1.Go to
	 * http://live.guru99.com 2.Go to Mobile menu and add Iphone to cart 3.Enter
	 * coupon code 4.Verify the discount generated
	 * 
	 */
	// ********************************************************************************************

	@Test
	public void TestCase09() {

		driver = new FirefoxDriver();

		String guru50 = "GURU50";
		String subTotal;
		double dSubTotal;
		double expectedDiscount;
		double discountCode = 5.0;
		double actualDiscount;

		// 1.Go to http://live.guru99.com
		HomePage homePage = WebUtil.loadPage(driver, BASE_URL);

		// 2.Go to Mobile menu and add Iphone to cart
		MobilePage mobilePage = homePage.clickOnMobileMenu(driver);
		CheckOutCartPage checkOutCartPage = mobilePage.addIphoneToCart(driver);

		// Calculate expected discount price
		subTotal = checkOutCartPage.getSubTotal(driver);
		subTotal = (subTotal.replace("$", "")).trim();
		dSubTotal = Double.parseDouble(subTotal);

		expectedDiscount = dSubTotal * (discountCode / 100);

		System.out.println("Expected Discount : " + expectedDiscount);

		// 3.Enter coupon code
		checkOutCartPage.applyDiscountCode(driver, guru50);

		// 4.Verify the discount generated
		String actualDisc = checkOutCartPage.getActualDiscount(driver);

		actualDisc = (actualDisc.replace("-$", "")).trim();
		actualDiscount = Double.parseDouble(actualDisc);

		AssertJUnit.assertEquals(actualDiscount, expectedDiscount);

		System.out.println("Actual Discount : " + actualDiscount);

	}

	// ********************************************************************************************
	/*
	 * Export all orders in csv file and display these information in console
	 * and you are able to send this file to another email id as attachment.
	 * Test Steps: 1.Go to http://live.guru99.com/index.php/backendlogin 2.Login
	 * with the credential provided 3.Go to sales -> orders menu 4.Select CSV in
	 * dropdown and click export button 5.Read downloaded file and display all
	 * order information in console 6.Attache the exported file and email to
	 * another email id
	 * 
	 */
	// ********************************************************************************************

	@Test
	public void TestCase10() {

		driver = new FirefoxDriver();
		String url = "http://live.guru99.com/index.php/backendlogin";
		String userName = "user01";
		String password = "guru99com";
		String fileType = "CSV";

		// 1.Go to http://live.guru99.com/index.php/backendlogin
		HomePage homePage = WebUtil.loadAdminPage(driver, url);

		// Login with the credential provided
		ManageCustomerPage manageCustomerPage = homePage.loginToAdminPanel(driver, userName, password);

		// 3.Go to sales -> orders menu
		SalesOrderPage salesOrderPage = manageCustomerPage.openSalesOrderPage(driver);

		// 4.Select CSV in dropdown and click export button
		salesOrderPage.selectCSVFileAndExport(driver, fileType);

	}

	// Take screen shots when test case failed

	public void tearDown(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {

			String fileName = result.getName();
			String imageName = fileName + ".png";
			String imagePath = "./Screenshots/Failure/" + imageName;
			WebUtil.takesScreenShot(driver, imagePath);
			String image = test.addScreenCapture(imagePath);
			test.log(LogStatus.FAIL, "Order Verification", image);

		}

		extent.flush();

		driver.close();
		driver.quit();
	}

}
