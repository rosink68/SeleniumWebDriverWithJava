package msg.group.practical_problems_javascriptexecutor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Driver in JavascriptExecutor casten
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Aufruf executeScript zum Ausführen von Javascript 
		
		// auf der Seite bis zur Tabelle "Web Table Fixed header" scrollen (Parameter: 1. auszuführendes Script)
		js.executeScript("window.scrollBy(0, 500)");
		
		Thread.sleep(500);
		
		// in der Tabelle nach unten scrollen
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");

		// alle Werte der Spalte "Amount"
		List<WebElement> amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int actualTotalAmount = 0;
		for (WebElement amount : amounts) {
			actualTotalAmount += Integer.parseInt(amount.getText()); 
		}
		
		System.out.println("Total amount: " + actualTotalAmount);
		
		int expectedTotalAmount = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
		System.out.println(expectedTotalAmount);
		
		Assert.assertEquals(actualTotalAmount, expectedTotalAmount);
		
		driver.quit();
	}

}
