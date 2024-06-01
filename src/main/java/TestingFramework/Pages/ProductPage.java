package TestingFramework.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestingFramework.AbstractComponent.AbstractComponent;

public class ProductPage extends AbstractComponent{

	WebDriver driver;
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".mb-3")
	List<WebElement> productLists;
	
	@FindBy(css=".ng-animating")
	 WebElement spinner;
	
	 By toastMessage = By.id("toast-container");
	 By productList = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	
	public List<WebElement> getProductList() {
		waitforElementToAppear(productList);
		return productLists;
	}
	public WebElement getProduct(String productname) {
		WebElement product = getProductList().stream().filter(s->s.findElement(By.tagName("b")).getText().equals(productname)).findAny().orElse(null);
		return product;
		
	}
	
	public void addProductToCart(String product) throws InterruptedException {
		WebElement prod = getProduct(product);
		prod.findElement(addToCart).click();
		waitforElementToAppear(toastMessage);
		waitforWebElementToDisAppear(spinner);
	}
	
	
}
