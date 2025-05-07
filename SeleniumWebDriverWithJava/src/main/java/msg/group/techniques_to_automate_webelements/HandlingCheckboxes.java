package msg.group.techniques_to_automate_webelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingCheckboxes {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// checkbox "Senior Citizen"
		//driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		// da die id so lang ist ==> cssSelector mit SeniorCitizenDiscount
		WebElement cbSeniorCitizenDiscount = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
		
		Assert.assertFalse(cbSeniorCitizenDiscount.isSelected(), "Checkbox 'Senior Citizen' is checked.");
		cbSeniorCitizenDiscount.click();
		Assert.assertTrue(cbSeniorCitizenDiscount.isSelected(), "Checkbox 'Senior Citizen' is not checked.");
		
		// Anzahl der Checkboxen unter den Auswahlfeldern ermitteln
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("div[id='discount-checkbox'] input[type='checkbox']"));
		int numberOfCheckboxes = checkboxes.size();
		Assert.assertTrue(numberOfCheckboxes == 5, "The number of checkboxes should be 5, but it is " + numberOfCheckboxes);
		// oder
		Assert.assertEquals(numberOfCheckboxes, 5);
		
		// jede Checkbox selektieren <== in dem Beispiel kann nur immer eine Checkbox aktiv sein
		for (WebElement checkbox : checkboxes) {
			checkbox.click();
		}
		
		driver.quit();
	}

}
