package msg.group.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import msg.group.abstractcomponents.AbstractComponent;

public class ProductCataloguePage extends AbstractComponent {

	WebDriver driver;
	
	public ProductCataloguePage(WebDriver driver) {
		
		// WebDriver zur Parentklasse senden
		super(driver);
		
		// initialization driver
		this.driver = driver;
		
		// Triggern des Initialisieren aller Elemente mit Hilfe der PageFactory 
		PageFactory.initElements(driver, this);
	}

	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css = ".mb-3")
	private List<WebElement> products;
	
	@FindBy(className = "ng-animating")
	private WebElement spinner;
	
	private By productsBy = By.cssSelector(".mb-3");
	private By addToCartBy = By.cssSelector(".card-body button:last-of-type");
	private By toastMessageBy = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		
		// stream() durchläuft die Liste von products
		// products ist die gesamte Karte, aber es soll nur der Text im <b>-Tag ermittelt werden
		// ==> in der Karte wird mit Hilfe von filter in jedem product zuerst nach <b> gesucht und
		// dann die Operation getText().equals(productName) ausgeführt (->)
		// Zurückgegeben des 1. WebElements mit dem Produktnamen oder null
		WebElement prod = getProductList().stream()
				.filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName))
				.findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		
		// im Scope von product den "add To Cart"-Button klicken
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCartBy).click();
		
		// warten bis das AnamationsIcon verschwindet und die Erfolgsmeldung " Product Added To Cart " erscheint
		
		// Das Warten auf den Spinner funktioniert nicht!!! ==> Workaround vom Teacher: Thread.sleep(1000);	
		//waitForElementToDisappear(spinner);
		waitForElementToDisappearWithThreadSleep();
		waitForElementToAppear(toastMessageBy);
		
	}
}
