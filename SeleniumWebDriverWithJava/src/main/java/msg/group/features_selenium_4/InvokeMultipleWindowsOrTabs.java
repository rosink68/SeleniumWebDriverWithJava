package msg.group.features_selenium_4;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvokeMultipleWindowsOrTabs {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		// in einem neuen Tab die Webseite https://rahulshettyacademy.com/ öffnen
//		driver.switchTo().newWindow(WindowType.TAB);
		// alternativ neues Fenster öffnen
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		// Fokus auf den neuen Tab stellen und andere URL eingeben
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iter = handles.iterator();
		String parentWindowId = iter.next();
		String childWindowId = iter.next();
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Home']")));
		
		// von allen Kursen der Seite den Titel des 1. sichtbaren Kurs ermitteln <== index = 0 ist nicht sichtbar
		String courseName = driver.findElements(
				By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();

		driver.close();
		
		// den Scope wieder zum ParentHandle geben
		driver.switchTo().window(parentWindowId);
		
		// Kursname in das Feld "Name" einfügen
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
		
//		driver.quit();
	}

}
