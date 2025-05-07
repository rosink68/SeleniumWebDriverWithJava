package msg.group.java_streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterWebTableUsingStreams {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Suchbegriff ins Suchfeld eingeben
		driver.findElement(By.id("search-field")).sendKeys("apple");
		
		// alle Einträge der Spalte "Veg/fruit name" ermitteln
		List<WebElement> veggiesList = driver.findElements(By.xpath("//tr/td[1]"));

		List<String> filteredList = veggiesList.stream()
					.filter(veggie-> veggie.getText().toUpperCase().contains("APPLE"))
					.map(veggie-> veggie.getText())
					.collect(Collectors.toList());
		filteredList.forEach(v-> System.out.println(v));
		
		// Prüfen, ob beide Liste die gleiche Anzahl von Elemente haben
		Assert.assertEquals(veggiesList.size(), filteredList.size());
		
		driver.quit();
	}

}
