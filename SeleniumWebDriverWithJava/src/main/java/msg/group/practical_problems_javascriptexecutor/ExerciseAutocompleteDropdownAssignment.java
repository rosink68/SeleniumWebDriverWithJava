package msg.group.practical_problems_javascriptexecutor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ExerciseAutocompleteDropdownAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
		WebElement autocompleteField = driver.findElement(By.id("autocomplete"));
		autocompleteField.sendKeys("ger");
		Thread.sleep(1000);
		
		List<WebElement> options = driver.findElements(By.cssSelector("#ui-id-1 li"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Germany")) {
				option.click();
				break;
			}
		}		
		
		Thread.sleep(1000);
		Assert.assertEquals(autocompleteField.getDomProperty("value"), "Germany");
		
		driver.quit();
	}
}
