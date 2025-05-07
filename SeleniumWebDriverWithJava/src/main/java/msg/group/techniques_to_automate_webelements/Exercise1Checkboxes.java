package msg.group.techniques_to_automate_webelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Exercise1Checkboxes {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/**
		 * 1. Check the first  Checkbox and verify if it is successfully checked 
		 * and Uncheck it again to verify if it is successfully Unchecked
		 */
		
		WebElement firstCheckbox = driver.findElement(By.id("checkBoxOption1"));
		Assert.assertFalse(firstCheckbox.isSelected(), "The first checkbox should not be checked.");
		firstCheckbox.click();
		Assert.assertTrue(firstCheckbox.isSelected(), "The first checkbox should be checked.");
		

		/**
		 * 2. How to get the Count of number of check boxes present in the page
		 */		
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		int numberOfCheckboxes = checkboxes.size();
		Assert.assertTrue(numberOfCheckboxes == 3, "The number of checkboxes should be 3, but it is " + numberOfCheckboxes);
		// or
		Assert.assertEquals(numberOfCheckboxes, 3);
		
		driver.quit();
	}

}
