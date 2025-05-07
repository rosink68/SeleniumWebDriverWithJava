package msg.group.techniques_to_automate_webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// open dropdown "PASSENGERS"
		WebElement passengersDropdown = driver.findElement(By.id("divpaxinfo"));
		passengersDropdown.click();

		Thread.sleep(2000);
		
		System.out.println("Before selecting: " + passengersDropdown.getText());

		// add 4 more ADULT by clicking "+" button 
		
		/* Lösung 1
		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();			
			i++;
		}*/
		
		// Lösung 2
		for (int i=1; i<5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();				
		}
		
		// click on "Done" button
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println("After selecting: " +passengersDropdown.getText());
		Assert.assertEquals(passengersDropdown.getText(), "5 Adult", 
				"It should be 5 Adult but choose only " + passengersDropdown.getText());
		
		driver.quit();
	}

}
