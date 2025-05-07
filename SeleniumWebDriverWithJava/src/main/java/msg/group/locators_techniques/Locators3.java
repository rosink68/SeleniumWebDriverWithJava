package msg.group.locators_techniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
				
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		/**
		 * Sibling - Child to parent traverse
		 */

		// Ermitteln des Login-Buttons, indem vom Header (Parent) zum Button (Child) navigiert wird
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

		// anderer Weg zum Login-Button (über Parent)
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		
		driver.quit();
	}
}
