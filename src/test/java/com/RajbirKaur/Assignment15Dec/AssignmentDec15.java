package com.RajbirKaur.Assignment15Dec;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentDec15 {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajbir\\drivers\\chromedriver.exe");
		// intialise webdriver instance.
         wd = new ChromeDriver();
		
		wd.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
		

		// load webpage
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account\r\n" + "/login");

	}

	@Test
	public void validateUserAblePurchase() {
		WebElement emailInput = wd.findElement(By.cssSelector("div.form-group:first-of-type input"));
		WebElement passInput = wd.findElement(By.cssSelector("div.form-group:last-of-type input"));
		emailInput.sendKeys("rajbir.kaur661@gmail.com");
		passInput.sendKeys("supermax.com");
		wd.findElement(By.cssSelector("input[type='submit']")).click();
		String titleOfpageAfterloginBtnClick = wd.getTitle();
		Assert.assertEquals(titleOfpageAfterloginBtnClick, "My Account");
		System.out.println("My account page's title is validated successfuly ");
		WebElement phoneandPDAlink = wd.findElement(By.cssSelector("ul.nav.navbar-nav li:nth-of-type(6) a"));
		String phnAndPDA = phoneandPDAlink.getText();
		Assert.assertEquals(phnAndPDA, "Phones & PDAs");
		System.out.println("Phones & PDAs link is present  on  My Account page");
		phoneandPDAlink.click();
		System.out.println("phone and pda link successfuly clicked");
		WebElement hTCTouchHDlink = wd.findElement(By.cssSelector(
				"div.row:nth-of-type(2) div.product-layout.product-grid.col-lg-4.col-md-4.col-sm-6.col-xs-12:first-of-type h4 a"));
		String hTCTouchHD = hTCTouchHDlink.getText();
		Assert.assertEquals(hTCTouchHD, "HTC Touch HD");
		hTCTouchHDlink.click();
		System.out.println("HTC Touch HD successfuly selected");
		WebElement addToCartLink = wd.findElement(By.cssSelector("button[id='button-cart']"));
		String addToCart = addToCartLink.getText();
		Assert.assertEquals(addToCart, "Add to Cart");
		addToCartLink.click();
		System.out.println("product successfuly added to Cart");
		WebElement addToCartbtnTextAfterSelectHtcTouchHDDisplayBtn = wd
				.findElement(By.cssSelector("div.btn-group.btn-block>button"));
        Assert.assertEquals(addToCartbtnTextAfterSelectHtcTouchHDDisplayBtn.getText(), "1 item(s) - $100.00");
		System.out.println("item purchase succesfuly showing with quantity and price");

		addToCartbtnTextAfterSelectHtcTouchHDDisplayBtn.click();

		WebElement checkoutLink = wd.findElement(By.cssSelector("p.text-right a:last-of-type"));
		checkoutLink.click();
		System.out.println("Checkout link clicked");

		WebElement firstNameInputField = wd.findElement(By.cssSelector("div.form-group.required:first-of-type input"));
		WebElement lastNameInputField = wd.findElement(By.cssSelector("div.form-group.required:nth-of-type(2) input"));
		WebElement companyInputField = wd.findElement(By.cssSelector("div.form-group:nth-of-type(3) input"));
		WebElement address1InputField = wd.findElement(By.cssSelector("div.form-group.required:nth-of-type(4) input"));
		WebElement address2inputField = wd.findElement(By.cssSelector("div.form-group:nth-of-type(5) input"));
		WebElement cityInputField = wd.findElement(By.cssSelector("div.form-group.required:nth-of-type(6) input"));
		WebElement postCodeInputField = wd.findElement(By.cssSelector("div.form-group.required:nth-of-type(7) input"));
		WebElement continueBtn = wd.findElement(By.cssSelector("input[id='button-payment-address']"));
		firstNameInputField.sendKeys("Rajbir");
		lastNameInputField.sendKeys("Kaur");
		companyInputField.sendKeys("samsung");
		address1InputField.sendKeys("123,surrey");
		address2inputField.sendKeys("avenue 5");
		cityInputField.sendKeys("whiterock");
		postCodeInputField.sendKeys("ave123");
		selectByValue(wd.findElement(By.cssSelector("select[name='country_id']")), "38");
		selectByValue(wd.findElement(By.cssSelector("select[name='zone_id']")), "609");
		continueBtn.click();
		WebElement radioBtnshippingAddress = wd
				.findElement(By.cssSelector("div.radio:first-of-type input[name='shipping_address']:first-of-type"));
		boolean isSelected = radioBtnshippingAddress.isSelected();
		Assert.assertTrue(isSelected);
		WebElement continueBtnDelievery = wd.findElement(By.cssSelector("input[id='button-shipping-address']"));
		continueBtnDelievery.click();
		boolean isSelectedCashDelivery = wd.findElement(By.cssSelector("input[name='payment_method']")).isSelected();
		Assert.assertTrue(isSelectedCashDelivery);

	}

//		verificationClickOnPhonesAndPda();
//		validationOfTitleOfPhonesPDAs();
//		verificationhtcHDSelection();
//		verificationClickonAddToCart();
//		validationPriceandProductSelectionandClick();
//		verifyclickOnCheckout();
//		validateBillingDetails();
//		

	

	/*
	 * public void validateTitleOfMyAccountPage() { WebElement emailInput =
	 * wd.findElement(By.cssSelector("div.form-group:first-of-type input"));
	 * WebElement passInput =
	 * wd.findElement(By.cssSelector("div.form-group:last-of-type input"));
	 * emailInput.sendKeys("raj.661@gmail.com"); passInput.sendKeys("123456");
	 * wd.findElement(By.cssSelector("input[type='submit']")).click(); String
	 * titleOfpageAfterloginBtnClick = wd.getTitle();
	 * Assert.assertEquals(titleOfpageAfterloginBtnClick, "My Account");
	 * System.out.println("My account page's title is validated successfuly ");
	 * 
	 * }
	 * 
	 * public void verificationClickOnPhonesAndPda() { WebElement phoneandPDAlink =
	 * wd.findElement(By.cssSelector("ul.nav.navbar-nav li:nth-of-type(6) a"));
	 * String phnAndPDA = phoneandPDAlink.getText(); Assert.assertEquals(phnAndPDA,
	 * "Phones & PDAs");
	 * System.out.println("Phones & PDAs link is present  on  My Account page");
	 * phoneandPDAlink.click();
	 * System.out.println("phone and pda link successfuly clicked");
	 * 
	 * }
	 * 
	 * public void validationOfTitleOfPhonesPDAs() { String
	 * titleOfpageAfterphoneandPDAlinkclick = wd.getTitle();
	 * Assert.assertEquals(titleOfpageAfterphoneandPDAlinkclick, "Phones & PDAs");
	 * System.out.println("Phones & PDAs title of page is validated successfuly ");
	 * 
	 * }
	 * 
	 * public void verificationClickonAddToCart() { WebElement addToCartLink =
	 * wd.findElement(By.cssSelector("button[id='button-cart']")); String addToCart
	 * = addToCartLink.getText(); Assert.assertEquals(addToCart, "Add to Cart");
	 * addToCartLink.click();
	 * System.out.println("product successfuly added to Cart");
	 * 
	 * }
	 * 
	 * public void verificationhtcHDSelection() { WebElement hTCTouchHDlink =
	 * wd.findElement(By.cssSelector(
	 * "div.row:nth-of-type(2) div.product-layout.product-grid.col-lg-4.col-md-4.col-sm-6.col-xs-12:first-of-type h4 a"
	 * )); String hTCTouchHD = hTCTouchHDlink.getText();
	 * Assert.assertEquals(hTCTouchHD, "HTC Touch HD"); hTCTouchHDlink.click();
	 * System.out.println("HTC Touch HD successfuly selected");
	 * 
	 * }
	 * 
	 * public void validationPriceandProductSelectionandClick() { WebElement
	 * addToCartbtnTextAfterSelectHtcTouchHDDisplayBtn = wd
	 * .findElement(By.cssSelector("div.btn-group.btn-block>button"));
	 * 
	 * Assert.assertEquals(addToCartbtnTextAfterSelectHtcTouchHDDisplayBtn.getText()
	 * , "1 item(s) - $122.00");
	 * System.out.println("item purchase succesfuly showing with quantity and price"
	 * );
	 * 
	 * addToCartbtnTextAfterSelectHtcTouchHDDisplayBtn.click();
	 * 
	 * }
	 * 
	 * public void verifyclickOnCheckout() {
	 * 
	 * WebElement checkoutLink =
	 * wd.findElement(By.cssSelector("p.text-right a:last-of-type"));
	 * checkoutLink.click(); System.out.println("Checkout link clicked");
	 * 
	 * }
	 * 
	 * public void validateBillingDetails() { WebElement firstNameInputField =
	 * wd.findElement(By.cssSelector("div.form-group.required:first-of-type input"))
	 * ; WebElement lastNameInputField =
	 * wd.findElement(By.cssSelector("div.form-group.required:nth-of-type(2) input")
	 * ); WebElement companyInputField =
	 * wd.findElement(By.cssSelector("div.form-group:nth-of-type(3) input"));
	 * WebElement address1InputField =
	 * wd.findElement(By.cssSelector("div.form-group.required:nth-of-type(4) input")
	 * ); WebElement address2inputField =
	 * wd.findElement(By.cssSelector("div.form-group:nth-of-type(5) input"));
	 * WebElement cityInputField =
	 * wd.findElement(By.cssSelector("div.form-group.required:nth-of-type(6) input")
	 * ); WebElement postCodeInputField =
	 * wd.findElement(By.cssSelector("div.form-group.required:nth-of-type(7) input")
	 * ); WebElement continueBtn =
	 * wd.findElement(By.cssSelector("div.pull-right input"));
	 * firstNameInputField.sendKeys("Rajbir"); lastNameInputField.sendKeys("Kaur");
	 * companyInputField.sendKeys("samsung");
	 * address1InputField.sendKeys("123,surrey");
	 * address2inputField.sendKeys("avenue 1");
	 * cityInputField.sendKeys("whiterock"); postCodeInputField.sendKeys("ver123");
	 * selectByValue(wd.findElement(By.cssSelector("select[name='country_id']")),
	 * "38");
	 * selectByValue(wd.findElement(By.cssSelector("select[name='zone_id']")),
	 * "609"); continueBtn.submit(); WebElement radioBtnShipping = wd
	 * .findElement(By.
	 * cssSelector("div.radio:first-of-type input[name='shipping_address']:first-of-type"
	 * )); boolean isSelected = radioBtnShipping.isSelected();
	 * Assert.assertTrue(isSelected); WebElement continueBtnDelievery =
	 * wd.findElement(By.cssSelector("input[id='button-shipping-address']"));
	 * continueBtnDelievery.click(); WebElement radioBtnFlatRate = wd
	 * .findElement(By.
	 * cssSelector("div.radio:first-of-type input[name='shipping_address']:first-of-type"
	 * )); boolean isSelectedFlat = radioBtnFlatRate.isSelected();
	 * Assert.assertTrue(isSelectedFlat); WebElement textAreaCommentInputFileld =
	 * wd.findElement(By.cssSelector("textarea[name='comment']"));
	 * textAreaCommentInputFileld.sendKeys("front of door");
	 *  wd.findElement(By.cssSelector("input[id='button-shipping-method']
	 * wd.findElement(By.cssSelector("input[id='button-shipping-method']")).click();
	 * 
	 * // String titleOfPage = wd.getTitle(); // * Assert.assertEquals(titleOfPage,
	 * "Your Store"); // * System.out.println("billing details are completed"); //
	 */
	

	public void selectByValue(WebElement element, String value) {
		Select sc = new Select(element);
		sc.selectByValue(value);
	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.close();
	}

}
