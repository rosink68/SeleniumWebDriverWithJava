package msg.group.techniques_to_automate_ajax_calls_window_handle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.de/");

		// Cookies ablehnen
		driver.findElement(By.id("sp-cc-rejectall-link")).click();
		
		
		// Action zum Handling von UI-Elementen
		Actions actions = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("div[id='nav-link-accountList'] a"));
		
		
		// write HELLO in search field
		// Moves to specific element, click and write HELLO <=0 Shift-Button muss gedrückt sein
		actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox")))
				.click()				// ins Suchfeld klicken, um den Cursor reinzustellen
				.keyDown(Keys.SHIFT)	// SHIFT-Taste für Großschreibung drück
				.sendKeys("hello")		// Eingabe Text
				.doubleClick()			// HELLO mit Doppelklick selektieren
				.build()				// den Befehl zusammenbauen
				.perform(); 			// den Befehl ausführen
		
		
		// build().perform() muss angehängt werden, um das Kommando auszuführen
		actions.moveToElement(move)
				.contextClick()			// Kontextmenü öffnen
				.build().perform();
	}
}
