package TestingFramework.Tests;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestingFramework.Pages.CartPage;
import TestingFramework.Pages.CheckoutPage;
import TestingFramework.Pages.ProductPage;
import TestingFramework.TestComponenet.BaseTest;
import TestingFramework.TestComponenet.Retry;

public class SubmitOrder extends BaseTest{
	
	@Test(dataProvider="getData", retryAnalyzer=Retry.class)
	public void SubmitOrderTest(HashMap<String,String> input) throws InterruptedException {
		ProductPage product = landing.launchApplication(input.get("email"), input.get("password"));
		List<WebElement> lists =product.getProductList();
		product.addProductToCart(input.get("product"));
		CartPage cart = product.goToCart();
		Boolean match = cart.verifyCartItem(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkpage = cart.goToCheckoutPage();
		checkpage.selectCountry("India");
		checkpage.goTo();	
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsondata("D:\\Selenium\\Scripts\\TestingFramework\\src\\test\\java\\TestingFramework\\Data\\data.json");
		return new Object[][]{{data.get(0)},{data.get(1)}};
	}

}
