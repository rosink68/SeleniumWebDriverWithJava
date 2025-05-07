package msg.group.deep_diving_into_functional_testing;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static void main(String[] args) {
		
		String productArray[] = {"Banana", "Cucumber", "Cucumber", "Grapes", "Banana", "Tomato", "Cucumber", "Apples"};
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		// alle Produkte ermitteln
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		
		// Lösung 1
//		for (int i=0; i<products.size(); i++) {
//			
//			if (products.get(i).getText().contains("Cucumber")) {
//				// da wir im Cucumber-Block sind, funktioniert 'ADD TO CART'
//				driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
//				break;
//			}
//			
//		}
		
		
		int i=0;
		// Lösung 2
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
		
		//driver.quit();
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
