package msg.group.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import msg.group.abstractcomponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		
		// WebDriver zur Parentklasse senden
		super(driver);
		
		// initialization driver
		this.driver = driver;
		
		// Triggern des Initialisieren aller Elemente mit Hilfe der PageFactory 
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".hero-primary")
	private WebElement confirmationMessage;
	
	public String verifyConfirmationMessage() {
		
		return confirmationMessage.getText();
	}
	
}
