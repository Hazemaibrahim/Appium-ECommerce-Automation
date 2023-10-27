package org.rahulshettyacademy.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	
	AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver) {

		this.driver=driver;
		
	}
	
	public void LongPressAction(WebElement element) {
		//perform long click using the key and value pair(element ID, element) for 2 seconds(duration)
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
						"duration",2000));
	}
	
	public void scrollToEndAction() {
		boolean canScrollMore;
		do
		{
			// Java
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0

			));
			
		}while(canScrollMore);
	}
	
	public void scrollToText(String text) {
		
		//method in appium used to scroll over a page until it find the given text element, here we concatinates text with the string
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	
	public void swipeAction(WebElement firstImage, String direction) {
		//swipe demo to swipe to the left direction 
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			"elementId",((RemoteWebElement)firstImage).getId(),
		    "direction", direction,
		    "percent", 0.75
		));
		
		
	}
	

}
