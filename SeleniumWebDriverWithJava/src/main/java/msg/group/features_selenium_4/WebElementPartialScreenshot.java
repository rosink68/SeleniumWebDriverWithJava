package msg.group.features_selenium_4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementPartialScreenshot {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// in einem neuen Tab die Webseite https://rahulshettyacademy.com/ öffnen
		driver.switchTo().newWindow(WindowType.TAB);
		
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
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);
		
		
		// Screenshot nur vom Namen machen & in Datei speichern
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("nameField.png"));
		
		
		// die Höhe und Weite vom WebElement "Name" ermitteln
		int width = name.getRect().getDimension().getWidth();
		int height = name.getRect().getDimension().getHeight();
		System.out.println("Width: " + width + " Height: " + height);
		System.out.println("Width: " + width + " Height: " + height);
		
		driver.quit();
	}

}
