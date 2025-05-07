package msg.group.real_time_exercises;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// 1. Determine the count of links on the entire page
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Links on entire page: " + allLinks.size());

		
		// 2. Determine the count of links in the footer section
		//List<WebElement> footerLinks = driver.findElements(By.cssSelector("div#gf-BIG a"));
		//System.out.println("All links in the footer: " + footerLinks.size());
		
		// Alternative: Limiting webdriver scope
		// eine Subsection/WebDriver für den Footer erstellen
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("Links in footer: " + footerDriver.findElements(By.tagName("a")).size());
		
		
		// 3. Determine the count of links in the first column of the footer
		// Subsection für die erste Spalte erstellen
		WebElement firstColumnDriver = footerDriver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
		List<WebElement> columnLinks = firstColumnDriver.findElements(By.tagName("a"));
		System.out.println("Links first column in footer: " + columnLinks.size());

		
		// 4. Click on each link in the column and check if the pages are opening in a seperate tab (STRG+Link)
		// Index[0] bleibt auf der Seite ==> bei Index[1] anfangen
		for (int i=1; i<columnLinks.size(); i++) {
			
			// Link über sendKeys in einem seperaten Tab öffnen
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnLinks.get(i).sendKeys(clickOnLinkTab);
			
		}
		
		
		// 5. Print the title of every window
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		while (iter.hasNext()) {
			driver.switchTo().window(iter.next());
			System.out.println(driver.getTitle());
		}

		driver.quit();
	}

}
