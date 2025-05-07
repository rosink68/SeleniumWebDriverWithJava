package msg.group.practical_problems_javascriptexecutor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ExerciseWebTablesAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Driver in JavascriptExecutor casten
		JavascriptExecutor js = (JavascriptExecutor) driver;
				
		// auf der Seite bis zur Tabelle "Web Table Example" scrollen
		js.executeScript("window.scrollBy(0, 600)");
		
		Thread.sleep(300);
		
		WebElement tableDriver = driver.findElement(By.xpath("//legend[text()='Web Table Example']/following-sibling::table/tbody"));
		
		List<WebElement> rows = tableDriver.findElements(By.tagName("tr"));
		System.out.println("Number of rows: " + rows.size());
		Assert.assertEquals(rows.size(), 11);
		
		List<WebElement> columns = tableDriver.findElements(By.tagName("th"));
		System.out.println("Number of columns: " + columns.size());
		Assert.assertEquals(columns.size(), 3);
		
		// den Inhalt der 2. Datenzeile auslesen
		List<WebElement> dataRow2 = tableDriver.findElements(By.xpath("tr[3]/td"));
		for (WebElement column : dataRow2) {
			System.out.println(column.getText());
		}
		// Alternative zur for-Schleife
		System.out.println(dataRow2.get(0).getText());
		System.out.println(dataRow2.get(1).getText());
		System.out.println(dataRow2.get(2).getText());	

		driver.quit();
	}

}
