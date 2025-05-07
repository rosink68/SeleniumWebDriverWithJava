package msg.group.locators_techniques;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) {
		String name = "rahul";
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		String password = getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String successMessage = driver.findElement(By.tagName("p")).getText();
		String headerMessage = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		
		System.out.println(successMessage);
		System.out.println(headerMessage);
		
		// 1. Parameter: das was wir aktuell vom Browser erhalten
		Assert.assertEquals(successMessage, "You are successfully logged in.");
		Assert.assertEquals(headerMessage, "Hello " + name + ",");
		
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		
		driver.quit();
	}
	
	public static String getPassword(WebDriver driver) {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();

		// extract password from "Please use temporary password 'rahulshettyacademy' to Login."
		// 0th index - Please use temporary password 
		// 1st index - rahulshettyacademy' to Login.
		String[] passwordArray = passwordText.split("'");
		
		// 0th index - rahulshettyacademy 
		// 1st index - to Login.
		//String[] passwordArray2 = passwordArray[1].split("'");
		//String password = passwordArray[0];
		
		// andere Schreibweise
		String password = passwordArray[1].split("'")[0];
		
		return password;
	}
}
