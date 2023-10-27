package org.MobileAutomation.AndroidAutomationProject;

import java.time.Duration;
import java.util.List;

import org.MobileAutomation.PageObjects.CartPage;
import org.MobileAutomation.PageObjects.FormPage;
import org.MobileAutomation.PageObjects.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class eCommerceTestCase_1 extends BaseTest {

	
	@Test
	public void verifyEmptyNameError() {
		
		//creates instance of FormPage class to use its methods
		FormPage formpage= new FormPage(driver);
		
		//select gender
		formpage.setGender("Male");
		
		//click on the country to select
		formpage.selectCountry("Egypt");
		
		//click on lets shop
		formpage.submitForm();
		//Thread.sleep(1000);
		
		//gets the first toast message when the user doesn't enter a username
		String toastMessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		
		//verify that click on lets shop(submit) button without entering a name will give a toast message(please enter your name)
		Assert.assertEquals(toastMessage, "Please enter your name");
		
	}
	

	

	
	
	
	

}
