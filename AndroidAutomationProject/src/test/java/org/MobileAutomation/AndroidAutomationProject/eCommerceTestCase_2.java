package org.MobileAutomation.AndroidAutomationProject;

import org.MobileAutomation.PageObjects.CartPage;
import org.MobileAutomation.PageObjects.FormPage;
import org.MobileAutomation.PageObjects.ProductsPage;
import org.testng.annotations.Test;

public class eCommerceTestCase_2 extends BaseTest{
	
	@Test
	public void eCommerceWorkFlow() throws InterruptedException {
		
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
		
		//Adds two products to cart
		productsPage.addProductToCart("Air Jordan 9 Retro");
		productsPage.addProductToCart("PG 3");
	
		//click on cart icon
		productsPage.clickOnCartPage();
		
		//creates instance of CarPage class to use its methods
		CartPage cartPage= new CartPage(driver);
		
		//accept terms and conditions 
		cartPage.acceptTermsAndConditions();
		
		//click in visit the website button
		cartPage.submitOrder();
		
		//waits till the website(Google.com) loads
		Thread.sleep(3000);
	}

}
