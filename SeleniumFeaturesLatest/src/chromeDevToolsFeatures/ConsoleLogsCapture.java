package chromeDevToolsFeatures;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogsCapture {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		
		// Fehler loggen, wenn Test fehlschlägt
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.linkText("Browse Products")).click();
		
		// Selenium auswählen und zum Einkaufswagen zufügen
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		driver.findElement(By.linkText("Cart")).click();
		
		// im Einkaufswagen die Anzahl ändern
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");

		// die Log-Einträge holen, die vom Browser geloggt werden
		LogEntries entries = driver.manage().logs().get(LogType.BROWSER); // get LogEntries object
		// Log-Einträge extrahieren
		List<LogEntry> logs = entries.getAll(); // LogEntryObject - getAll method return all log in list
		
		for (LogEntry logEntry : logs) { // iterating through list and printing each log message
			System.out.println(	logEntry.getMessage());
		}
		
		driver.close();
	}
}
