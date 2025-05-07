package msg.group.java_streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PerformWebTableSorting {

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
		
		// 6. scan the name column with getText -> Beans -> print the price of the beans
		// 1. das WebElement mit dem Text "Beans" filtern; 2. den Preis ermitteln; 3. in eine Liste ausgeben
		// Info: wenn "Beans" nicht in filter(s-> s.getText().contains("Beans") gefunden wird,
		//		 wird map(s-> getPriceVeggie(s)) nicht ausgeführt und die Preisliste ist leer.
		List<String> priceBeans = elementsList.stream()
									.filter(s-> s.getText().contains("Beans"))
									.map(s-> getPriceVeggie(s))		// Methode wird nur auf WebElement "Beans" ausgeführt 
									.collect(Collectors.toList());
		priceBeans.forEach(a-> System.out.println(a));
		
		// 7. scan the name column with getText -> Rice -> print the price of the rice
		// Rice befindet sich nicht auf der 1. Seite ==> bis zue Seite blättern, auf der sich Rice befindet
		List<String> price;
		// do-while, da die Schleife mindestens 1x ausgeführt werden soll
		do {	
			// Inhalt der Spalte "Veg/fruit name" ermitteln 
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			
			price = rows.stream()
						.filter(s-> s.getText().contains("Rice"))	// Ermitteln des WebElements für Rice
						.map(s-> getPriceVeggie(s))					// Methode wird nur auf WebElement "Rice" ausgeführt 
						.collect(Collectors.toList());
			price.forEach(a-> System.out.println(a));
			
			// wenn Rice nicht auf der 1. Seite gefunden wurde ==> auf der nächsten Seite suchen
			if (price.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		
		// Schleife bricht ab, wenn ein Preis gefunden wurde ==> aansonsten erneuter Schleifendurchlauf
		} while (price.size() < 1);
		

		//driver.quit();
	}

	private static String getPriceVeggie(WebElement s) {
		
		// der Price ist der nächste Sibling von der Spalte "Veg/fruit name" 
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return price;
	}

}
