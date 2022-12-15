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

public class Assign215dec {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajbir\\drivers\\chromedriver.exe");
		// intialise webdriver instance.
		wd = new ChromeDriver();

		wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// load webpage
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account\r\n" + "/login");// navigation to page

	}

	@Test
	public void validateUserAblePurchase() {
		WebElement emailInput = wd.findElement(By.cssSelector("div.form-group:first-of-type input"));// email input
																										// field
		WebElement passInput = wd.findElement(By.cssSelector("div.form-group:last-of-type input"));// password input
																									// input
		emailInput.sendKeys("maninderajbir786@gmail.com");// email added
		passInput.sendKeys("supermax");// password provided
		wd.findElement(By.cssSelector("input[type='submit']")).click();// click on login
		String titleOfpageAfterloginBtnClick = wd.getTitle();// get Title of my account page
		Assert.assertEquals(titleOfpageAfterloginBtnClick, "My Account");// verify title of page
		System.out.println("My account page's title is validated successfuly ");
		WebElement phoneandPDAlink = wd.findElement(By.cssSelector("ul.nav.navbar-nav li:nth-of-type(6) a"));// phoneand pda linkonmyaccount pagefound
																												
		String phnAndPDA = phoneandPDAlink.getText();
		Assert.assertEquals(phnAndPDA, "Phones & PDAs");
		System.out.println("Phones & PDAs link is present  on  My Account page");
		phoneandPDAlink.click();// click on phone and pdas link
		System.out.println("phone and pda link successfuly clicked");

		WebElement palmTreoProlink = wd.findElement(By.cssSelector(
				"div.row:nth-of-type(2) div.product-layout.product-grid.col-lg-4.col-md-4.col-sm-6.col-xs-12:last-of-type h4 a"));
		String palmtreopro = palmTreoProlink.getText();
		Assert.assertEquals(palmtreopro, "Palm Treo Pro");// palm treo present on page
		palmTreoProlink.click();// click on palm treo pro link
		System.out.println(" Palm Treo Pro successfuly selected");
		WebElement addToCartLink = wd.findElement(By.cssSelector("button[id='button-cart']"));
		String addToCart = addToCartLink.getText();
		Assert.assertEquals(addToCart, "Add to Cart");
		addToCartLink.click();// click add to cart
		sleep();
		System.out.println("product successfuly added to Cart");
		WebElement addToCartbtnTextAfterSelectPalmTreProDisplayBtn = wd
				.findElement(By.cssSelector("div.btn-group.btn-block>button"));
		Assert.assertEquals(addToCartbtnTextAfterSelectPalmTreProDisplayBtn.getText(), "1 item(s) - $337.99");// validationof1
																												// item=price
		System.out.println("item purchase succesfuly showing with quantity and price");
		addToCartbtnTextAfterSelectPalmTreProDisplayBtn.click();
		WebElement checkoutLink = wd.findElement(By.cssSelector("p.text-right a:last-of-type"));
		checkoutLink.click();// click on checkout link
		System.out.println("Checkout link clicked");
		WebElement firstNameInputField = wd.findElement(By.cssSelector("div.form-group.required:first-of-type input"));
		WebElement lastNameInputField = wd.findElement(By.cssSelector("div.form-group.required:nth-of-type(2) input"));
		WebElement companyInputField = wd.findElement(By.cssSelector("div.form-group:nth-of-type(3) input"));
		WebElement address1InputField = wd.findElement(By.cssSelector("div.form-group.required:nth-of-type(4) input"));
		WebElement address2inputField = wd.findElement(By.cssSelector("div.form-group:nth-of-type(5) input"));
		WebElement cityInputField = wd.findElement(By.cssSelector("div.form-group.required:nth-of-type(6) input"));
		WebElement postCodeInputField = wd.findElement(By.cssSelector("div.form-group.required:nth-of-type(7) input"));
		WebElement continueBtnDelieveryDetails = wd.findElement(By.cssSelector("input[id='button-payment-address']"));
		firstNameInputField.sendKeys("Rajbir");
		lastNameInputField.sendKeys("Kaur");
		companyInputField.sendKeys("samsung");
		address1InputField.sendKeys("123,surrey");
		address2inputField.sendKeys("avenue 5");
		cityInputField.sendKeys("whiterock");
		postCodeInputField.sendKeys("ave123");
		selectByValue(wd.findElement(By.cssSelector("select[name='country_id']")), "38");
		selectByValue(wd.findElement(By.cssSelector("select[name='zone_id']")), "609");// all details are field on
																						// checkout for billing details
		continueBtnDelieveryDetails.click();// clicked on continue
		System.out.println("Delievery details are filled");// all details are field on checkout for billing details and
															// clicked on continue
		WebElement radioBtnshippingAddress = wd
				.findElement(By.cssSelector("div.radio:first-of-type input[name='shipping_address']:first-of-type"));
		boolean isSelectedshipping = radioBtnshippingAddress.isSelected();// validationof radio button selctedon
																			// delevery details
		Assert.assertTrue(isSelectedshipping);
		System.out.println("shipping radio button clicked");
		sleep();
		WebElement continueBtnShippingAddressAdd = wd
				.findElement(By.cssSelector("input[id='button-shipping-address']"));
		continueBtnShippingAddressAdd.click();// click on continue button of deleivery details
		System.out.println("delivery details continue button clicked");
		WebElement radioBtnFlatShipping = wd.findElement(By.cssSelector("input[name='shipping_method']"));
		boolean isSelectedshippingmethod = radioBtnFlatShipping.isSelected();
		Assert.assertTrue(isSelectedshippingmethod);// validation of RADIO BUTTON of delevery method
		System.out.println("shipping radio button clicked");
		WebElement textAreaInputShippingDetails = wd.findElement(By.cssSelector("textarea[name='comment']"));
		textAreaInputShippingDetails.sendKeys("front of door");// entry of text
		System.out.println("shippimng details textarea done");
		WebElement continueBtnDeliveryshipping = wd.findElement(By.cssSelector("input[id='button-shipping-method']"));
		continueBtnDeliveryshipping.click();// clickon continue button of delievry method
		System.out.println("shipping method details done");
		WebElement cashOnDelieveryRadioBtn = wd.findElement(By.cssSelector("input[name='payment_method']"));
		boolean isSelectedCashDelivery = cashOnDelieveryRadioBtn.isSelected();// radio button of payment method selected
		Assert.assertTrue(isSelectedCashDelivery);
		System.out.println("cash delevery radio button clicked");
		WebElement agreePayment = wd.findElement(By.cssSelector("input[name='agree']"));
		agreePayment.click();// select of terms and condition on paymentmethod
		System.out.println("agree clicked");
		WebElement continueBtnPayment1 = wd.findElement(By.cssSelector("input[id='button-payment-method']"));
		continueBtnPayment1.click();// click on continue button of payment method
		System.out.println("payment method button clicked");
		WebElement selctedProductCorrectLink = wd.findElement(By.cssSelector("div.panel-body td.text-left a"));
		sleep();
		selctedProductCorrectLink.getText();
		sleep();
		Assert.assertEquals(selctedProductCorrectLink.getText(), "Palm Treo Pro");
		System.out.println("Correct product selected");
		WebElement selctedProductQuantity = wd
				.findElement(By.cssSelector("table.table.table-bordered.table-hover tbody tr td:nth-of-type(3)"));
		System.out.println("Correct quantity of product11 selected");
		sleep();

		Assert.assertEquals(selctedProductQuantity.getText(), "1");
		System.out.println("Correct quantity of product selected");
		sleep();

		WebElement confirmOrderBtn = wd.findElement(By.cssSelector("input[id='button-confirm']"));// confirm button
																									// clicked confirm
																									// order
		confirmOrderBtn.click();
		System.out.println("order confirmed");
		WebElement orderPlacedTextLink = wd
				.findElement(By.cssSelector("div[id='common-success'] div.row div.col-sm-12 h1"));
		sleep();
		String orderPlaceText = orderPlacedTextLink.getText();
		Assert.assertEquals(orderPlaceText, "Your order has been placed!");// validation of text "your order has been
																			// placed

	}

	public void selectByValue(WebElement element, String value) {
		Select sc = new Select(element);
		sc.selectByValue(value);
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		// wd.close();
	}

}
