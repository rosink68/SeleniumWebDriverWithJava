package chromeDevToolsFeatures;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		
		// create session between selenium code and chrome browser 
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		// Madrid: Latitude = 40 und Longitude = 3 <== die und weitere Parameter optional
		// https://chromedevtools.github.io/devtools-protocol/tot/Emulation/#method-setGeolocationOverride
		Map<String, Object> coordinates = new HashMap<String, Object>();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);

		// hier könnte auch send(Emulation.setGeolocationOverride...) verwendet werden
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

		driver.get("https://google.com");
		// Zwischendialog ablehnen
		driver.findElement(By.cssSelector("#W0wltc")).click();
		
		Thread.sleep(100);
		
		driver.findElement(By.name("q")).sendKeys("msg systems AG", Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String title = driver.getTitle();
		System.out.println(title);

	}

}
