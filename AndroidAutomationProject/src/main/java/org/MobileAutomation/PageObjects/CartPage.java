package org.MobileAutomation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {
	
	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		
		//calls parentClass(AndroidActions) constructor
		super(driver);
		
		this.driver=driver;
		
		//initialize elements
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void acceptTermsAndConditions() {
		
		//long press on terms and then click on accept terms
		WebElement terms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		LongPressAction(terms);
		
		driver.findElement(By.id("android:id/button1")).click();
	}
	
	public void submitOrder() {
		
		//click on checkbox
		driver.findElement(By.xpath("//android.widget.CheckBox")).click();
		
		//click on proceed
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	}

}
