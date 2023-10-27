package org.MobileAutomation.AndroidAutomationProject;

import org.MobileAutomation.PageObjects.FormPage;
import org.MobileAutomation.PageObjects.ProductsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerceTestCase_3 extends BaseTest {
	
	@Test
	public void verifyEmptyCartError() {
		
		//creates instance of FormPage class to use its methods
		FormPage formpage= new FormPage(driver);
		
		//enter userName
		formpage.enterName("Hazem Ahmed");
		
		//select gender
		formpage.setGender("Male");
		
		//click on the country to select
		formpage.selectCountry("Egypt");
		
		//click on lets shop
		formpage.submitForm();
		
		//creates instance of CartPage class to use its methods
		ProductsPage productsPage=new ProductsPage(driver);

		//click on cart icon without adding products
		productsPage.clickOnCartPage();
		
		//gets the first toast message when the user doesn't add a product to cart
		String toastMessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		
		//verify that click on cartButton without adding a product to cart will give an error and toast message
		Assert.assertEquals(toastMessage, "Please add some product at first");
		
		
	}

}
