package org.MobileAutomation.AndroidAutomationProject;
	
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
		
		//configuration code for appium
		
		//code to start the server. gets the location for the .js file and ip address and port 
		service = new AppiumServiceBuilder()
		.withAppiumJS(new File("C://Users//Lenovo//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1")
		.usingPort(4723).build();
		service.start();
		
		//creates a object called options from UIAutomator class
		UiAutomator2Options options= new UiAutomator2Options();
		
		//add virtual  android device name
		options.setDeviceName("MyPhone");
		
		//add chrome driver path for browser automation
		//options.setChromedriverExecutable("C:\\Users\\Lenovo\\Desktop\\Driver\\chromedriver.exe");
		
		//adds location for the Guru to be opened on the android virtual device
		options.setApp("C:\\Users\\Lenovo\\Desktop\\resources\\General-Store.apk");
		
		//AndroidDriver
		driver=new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
		
		//wait for the element to be visible until 10 seconds, if not visible then it will fail
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void LongPressAction(WebElement element) {
		//perform long click using the key and value pair(element ID, element) for 2 seconds(duration)
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
						"duration",2000));
	}
	
	
	@AfterClass
	public void tearDown() {
		
        //close session and stop service
		driver.quit();
		service.stop();
	}

}
