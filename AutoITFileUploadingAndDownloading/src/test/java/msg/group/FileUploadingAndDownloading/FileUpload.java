package msg.group.FileUploadingAndDownloading;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
				
		String downloadPath=System.getProperty("user.dir");

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		// Festlegen des Verzeichnis, in dem die Download-Datei gespeichert werden soll
		// Parameter: 1. Property in Chrome; 2. Wert (default: Download-Verzeichnis
		// wenn das Property nicht gesetzt wird)
		chromePrefs.put("download.default_directory", downloadPath);
		
		ChromeOptions options = new ChromeOptions();
		// Setzen der Preferenzen für den Chrome-Browser
		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://pdftojpg.org/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		// Zustimmug wegklicken
		driver.findElement(By.className("fc-button-label")).click();
		
		WebElement uploadButton = driver.findElement(By.cssSelector("[class*='file-start__choose']"));
		wait.until(ExpectedConditions.visibilityOf(uploadButton));
		uploadButton.click();
		Thread.sleep(3000);
		
		// Ausführen Java zum Öffnen der exe-Datei zum Ausführen des Uploads
		// Parameter: Pfad zur auszuführenden Datei ("C:\\Users\\rosink\\eclipse-workspace-SeleniumWebDriverWithJava\\AutoITFileUploadingAndDownloading")
		Runtime.getRuntime().exec(downloadPath + "\\fileupload.exe");
		
		WebElement convertButton = driver.findElement(By.xpath("(//a[text()='Convert'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(convertButton));
		convertButton.click();
		 
		WebElement downloadButton = driver.findElement(By.xpath("//a[@class='btn start-download']"));
		wait.until(ExpectedConditions.elementToBeClickable(downloadButton));
		downloadButton.click();
		Thread.sleep(5000);

		// Prüfen, of File downloaded wurde
		File f=new File(downloadPath+"/VR3339233.zip");

		if(f.exists()) {
			Assert.assertTrue(f.exists());

			if(f.delete()) {
				System.out.println("file deleted");				
			}
		}		
	}

}
