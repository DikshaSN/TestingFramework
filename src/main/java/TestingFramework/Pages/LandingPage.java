package TestingFramework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestingFramework.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userEmail")
	WebElement emailbox;
	
	@FindBy(id="userPassword")
	WebElement passwordBox;
	
	@FindBy(id="login")
	WebElement submitButton;
	
	public void goToLoginPage() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public ProductPage launchApplication(String useremail, String password) {
		emailbox.sendKeys(useremail);
		passwordBox.sendKeys(password);
		submitButton.click();
		ProductPage product = new ProductPage(driver);
		return product;
	}
}
