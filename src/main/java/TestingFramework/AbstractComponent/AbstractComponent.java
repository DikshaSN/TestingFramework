package TestingFramework.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestingFramework.Pages.CartPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="button[routerlink*='cart']")
	WebElement cartButton;
	
	public void waitforElementToAppear(By ele) {
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	
	public void waitforWebElementToAppear(WebElement ele) {
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitforWebElementToDisAppear(WebElement ele) throws InterruptedException {
		Thread.sleep(2000);
	}
	
	public CartPage goToCart() {
		cartButton.click();
		CartPage cart = new CartPage(driver);
		return cart;
	}
}
