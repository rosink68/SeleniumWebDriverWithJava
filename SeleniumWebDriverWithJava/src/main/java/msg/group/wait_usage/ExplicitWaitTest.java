package msg.group.wait_usage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTest {

	public static void main(String[] args) {
		
		String productArray[] = {"Banana", "Cucumber", "Grapes", "Tomato"};
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		addItems(driver, productArray);
		
		// zum Einkaufswagen gehen
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		// auf der Einkaufswagenseite
		// PromoCode eingeben und den Apply-Button klicken 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode"))).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		// PromoInfo prüfen: "Code applied ..!" bzw. "Invalid code ..!"
		String promoInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))).getText();
		System.out.println(promoInfo);
		
		
		//driver.quit();
	}
	
	public static void addItems(WebDriver driver, String productArray[]) {
		
		// alle Produkte ermitteln
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		int i=0;
		for (WebElement product : products) {
			
			String productName = (product.getText().split("-"))[0].trim();
			/**
			
			// Array in eine ArrList konvertieren und prüfen, ob das Produkt in der Produktliste enthalten is 
			List<String> productList = Arrays.asList(productArray);
			// ABER contains funktioniert nur, wenn der hintere Teil entfernt wird 
			if (productList.contains(productName)) {
				// da wir im Cucumber-Block sind, funktioniert 'ADD TO CART'
				driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
			}
			*/
			
			int k = products.indexOf(product);
			// bessere Lösung über Stream
			if (Arrays.stream(productArray).anyMatch(product.getText()::contains)) {
				// da wir im Cucumber-Block sind, funktioniert 'ADD TO CART', aber man kann auch den Button suchen
				//driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
				int numberProduct = countDuplicateProduct(productArray, productName);
				for (int z=0; z<numberProduct; z++) {
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(k).click();					
				}
				
				i++;
			}
			
			// Abbruch, wenn alle Produkte gekauft wurden
			if (i == productArray.length) {
				break;
			}
			
		}
	}
	
	public static int countDuplicateProduct(String productArray[], String product) {
		
		int i=0;
		for (String p : productArray) {
			
			if (p.equals(product)) {
				i++;
			}	
		}
		
		return i;
	}

}
