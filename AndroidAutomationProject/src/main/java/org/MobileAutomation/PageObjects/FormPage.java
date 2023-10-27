package org.MobileAutomation.PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		//calls parentClass(AndroidActions) constructor
		super(driver);
		this.driver=driver;
		
		//initialize elements
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hazem Ahmed");
	

	//Android element locator=

	
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	
	public void enterName(String name) {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys(name);
		
		//hides keyboard after entering the name
		driver.hideKeyboard();
	}
	
	public void setGender(String gender) {
		
		//sets the gender for user
		
		if(gender.contains("Female")){
			
			driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		}
		else 
		{
			driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		}
			
	}
	
	public void selectCountry(String countryName) {
		
		//click on the country to select
		driver.findElement(By.id("android:id/text1")).click();
		
		//method in appium used to scroll over a page until it find the"element
		scrollToText(countryName);
		
		//click on the country
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
		
	}
	
	public void submitForm() {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}
	
	public String gettoastMessageAttribute() {
		
		//return the attribute of toastMessage
		
		WebElement toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]"));
		return toastMessage.getAttribute("name");
	}
	

}
