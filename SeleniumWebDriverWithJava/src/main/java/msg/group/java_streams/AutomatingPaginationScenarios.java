package msg.group.java_streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutomatingPaginationScenarios {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// 1. click on column "Veg/fruit name" <== um die Tabelle nach der Spalte zu sortieren
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		// 2. cature all webelements into list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		// 3. capture text of all webelements into new (original) list
		// der Stream wird manipuliert, indem für jedes Element der Liste der Text genommen wird 
		// d.h. aus der WebElemntList wird eine String-List
		List<String> originalList = elementsList.stream().map(s-> s.getText()).collect(Collectors.toList());
		
		// 4. sort on the original list of step 3 ==> prepare sorted list 
		// Originalliste in eine neue Liste sortieren
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		// 5. compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		// 6. scan the name column with getText -> Beans -> print the price od the rice
		// 1. das WebElement mit dem Text "Beans" filtern; 2. den Preis ermitteln; 3. in eine Liste ausgeben
		List<Object> price = elementsList.stream().filter(s-> s.getText().contains("Beans"))
							 .map(s-> getPriceVeggie(s))		// Methode wird nur auf WebElement "Beans" ausgeführt 
							 .collect(Collectors.toList());
		price.forEach(a-> System.out.println(a));
		
		driver.quit();
	}

	private static String getPriceVeggie(WebElement s) {
		
		// der Price ist der nächste Sibling von der Spalte "Veg/fruit name" 
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return price;
	}

}
