package com.RajbirKaur.Assignment15Dec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentDec15 {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajbir\\drivers\\chromedriver.exe");
		// intialise webdriver instance
		wd = new ChromeDriver();
		// load webpage
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account\r\n" + "/login");

	}

	@Test
	public void validateUserCanDoPurchase() {
		WebElement emailInput = wd.findElement(By.cssSelector("div.form-group:first-of-type input"));
		WebElement passInput = wd.findElement(By.cssSelector("div.form-group:last-of-type input"));
		WebElement loginBtn = wd.findElement(By.cssSelector("input[type='submit']"));
		emailInput.sendKeys("mnarajbir786@gmail.com");
		passInput.sendKeys("supermax.com");
		loginBtn.click();
		String titleOfPage = wd.getTitle();
		Assert.assertEquals(titleOfPage, "My Account");
		System.out.println("Your are successfully login ");
		WebElement contentPresent=wd
		//String contP=contentPresent.getText();

	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		// wd.close();
	}




}
