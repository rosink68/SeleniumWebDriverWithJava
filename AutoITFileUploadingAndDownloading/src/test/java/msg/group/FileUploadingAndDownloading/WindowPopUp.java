package msg.group.FileUploadingAndDownloading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		// Aufruf Login-Windows-Dialog mit Username & PW über AutoIT
		// <== auf diesen kann nicht mit Selenium zugegriffen werden
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();

		// Prüfen,ob Login erfolgreich war
		String actual = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).getText();
		System.out.println(actual);
		
		driver.close();
	}

}
