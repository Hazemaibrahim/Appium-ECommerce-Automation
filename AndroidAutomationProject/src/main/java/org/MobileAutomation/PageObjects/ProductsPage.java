package org.MobileAutomation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage extends AndroidActions {
	
	AndroidDriver driver;
	
	public ProductsPage(AndroidDriver driver) {
		
		//calls parentClass(AndroidActions) constructor
		super(driver);
		
		this.driver=driver;
		
		//initialize elements
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void addProductToCart(String elementName) {
		
		scrollToText(elementName);
		
		//initalize count of products that show on screen
		int productCount=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		// Iterate through the products on the screen
		for(int i=0; i<productCount; i++)  
		{
			//Get name of current product
			String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
					
			if(productName.equalsIgnoreCase(elementName)) {
						
				//click on add to cart
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
					
		}
	}
	
	public void clickOnCartPage() {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

	}
	

	

}
