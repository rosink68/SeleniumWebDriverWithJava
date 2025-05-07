package msg.group.techniques_to_automate_webelements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

	public static void main(String[] args) {
		
		String text = "Emilia";
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("name")).sendKeys(text);
		// alert only with Ok button
		driver.findElement(By.cssSelector("#alertbtn")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.id("name")).sendKeys(text);
		// alert only with Ok and Confirm button
		driver.findElement(By.id("confirmbtn")).click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.dismiss();
		
		driver.quit();
	}

}
