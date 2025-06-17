package msg.group.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTestBase {

	public static void main(String[] args) {
		
		String productName = "ZARA COAT 3";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client/");
		
		// Login
		driver.findElement(By.id("userEmail")).sendKeys("ewaldostehr@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Paul3005");
		driver.findElement(By.id("login")).click();
		
		
		// Shop
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		// stream() durchläuft die Liste von products
		// products ist die gesamte Karte, aber es soll nur der Text im <b>-Tag ermittelt werden
		// ==> in der Karte wird mit Hilfe von filter in jedem product zuerst nach <b> gesucht und
		// dann die Operation getText().equals("ZARA COAT 3") ausgeführt (->)
		// Zurückgegeben des 1. WebElements mit dem Namen "ZARA COAT 3" oder null
		WebElement prod = products.stream()
				.filter(product-> product.findElement(By.tagName("b")).getText().equals(productName))
				.findFirst().orElse(null);
		
		// im Scope von product den "add To Cart"-Button klicken
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		// warten bis das Anamations-Icon verschwindet und die Erfolgsmeldung " Product Added To Cart " erscheint
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("ng-animating"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));

		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		
		// My Cart
		// alle Produkte im Warenkorb ermitteln
		// .cartSection h3 entspricht //div[@class='cartSection']/h3 oder [class='cartSection'] h3
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		// NICHT filtern, sondern mit anyMatch prüfen, ob "ZARA COAT 3" im Warenkorb enthalten ist
		boolean match = cartProducts.stream()
				.anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		// den "Checkout" Button klicken
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
		// Payment
		//driver.findElement(By.cssSelector(".form-group input")).sendKeys("Ind");

		// ein Land selektieren mit Hilfe von Actions class
		Actions a = new Actions(driver);
		// 1. Parameter: Webelement, 2. Parameter: Land
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india")
		.build().perform();
		// warten bis die Liste aufklappt
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		// der 2. Eintrag "India" könnte so ermittelt werden:
		// (//button[contains(@class,'ta-item')])[2] oder .ta-item:nth-of-type(2)
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
		/**
		 * Alternative mit Streams
		 * 
		List<WebElement> countries = driver.findElements(By.cssSelector(".list-group-item"));
		WebElement countrySelected = countries.stream().filter(country-> country.getText().equalsIgnoreCase("India"))
				 .findFirst().orElse(null);
		if (countrySelected != null) {
			countrySelected.click();			
		}
		*/
		
		// auf den "Place Order" Button klicken
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		
		// THANKYOU FOR THE ORDER.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		String confirmMessage = driver.findElement(By.className("hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		driver.quit();
	}

}
