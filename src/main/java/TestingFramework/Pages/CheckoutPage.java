package TestingFramework.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestingFramework.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

		@FindBy(css="input[placeholder='Select Country']")
		WebElement countrybox;
		
		@FindBy(css=".list-group-item")
		List<WebElement> countrys;
		
		@FindBy(css=".action__submit")
		WebElement submitButton;
		
		public String getCountry(String country) {
			return country;
		}
		
		public void selectCountry(String country) {
			Actions a = new Actions(driver);
			a.sendKeys(countrybox, country).build().perform();
			WebElement India = countrys.stream().filter(s->s.getText().equalsIgnoreCase(country)).findFirst().orElse(null);
			India.click();
			
		}
		
		public void goTo() {
			submitButton.click();
		}
}
