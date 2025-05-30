package msg.group.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import msg.group.abstractcomponents.AbstractComponent;

public class OrderPage extends AbstractComponent {

	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		
		// WebDriver zur Parentklasse senden
		super(driver);
		
		// initialization driver
		this.driver = driver;
		
		// Triggern des Initialisieren aller Elemente mit Hilfe der PageFactory 
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;

	public List<WebElement> getProductNamesList() {
		
		return productNames;
	}

	public Boolean verifyOrderDisplay(String productName) {
		
		// NICHT filtern, sondern mit anyMatch prüfen, ob das Produkt mit dem Prduktnamen im Warenkorb enthalten ist
		boolean match = getProductNamesList().stream()
				.anyMatch(name-> name.getText().equalsIgnoreCase(productName));
		return match;
	}

}
