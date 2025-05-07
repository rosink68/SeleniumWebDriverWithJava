package msg.group.miscellaneous_topics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShots {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// das WebDriver-Objekt in ein TakeScreenShot-Method-Objekt 
		// ==> getScreenshotAs ist erst nach casten sichtbar
		// den Screen in ein File-Format ausgeben
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// die Datei auf unser lokales LW kopieren
		FileUtils.copyFile(src, new File("C:\\Users\\rosink\\Desktop\\screenshot.png"));
		
		Thread.sleep(500);
		
		driver.quit();
	}

}
