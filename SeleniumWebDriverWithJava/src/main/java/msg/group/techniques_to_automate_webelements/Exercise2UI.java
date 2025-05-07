package msg.group.techniques_to_automate_webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Exercise2UI {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.xpath("//div[@class='form-group'] //input[@name='name']")).sendKeys("Max Mustermann");
		driver.findElement(By.xpath("//div[@class='form-group'] //input[@name='email']")).sendKeys("Maxi.Musti@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Maxi12345");
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement genderDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select gender = new Select(genderDropdown);
		gender.selectByVisibleText("Female");
		
		driver.findElement(By.id("inlineRadio2")).click();
		
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("01.04.1999");
		
		driver.findElement(By.cssSelector("input[value='Submit']")).click();

		// Assertions
		String successMessage = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible'] strong")).getText();
		Assert.assertEquals(successMessage, "Success!", "The expected message is " + successMessage + ", but should be 'Success!'");
		
		driver.quit();

	}

}
