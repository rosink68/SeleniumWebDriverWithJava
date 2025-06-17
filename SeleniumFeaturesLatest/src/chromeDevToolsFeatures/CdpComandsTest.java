package chromeDevToolsFeatures;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CdpComandsTest {

	public static void main(String[] args) throws InterruptedException {

		/**
		 * Fluss der Kommandos
		 * 
		 * WebDriver ---> send(Command) ---> Selenium Server 	 ---> Chrome DevTools Protocol (CDP)
		   Code							 	 Interprets Commands				^
		   		|																|
		   		-------------------- executeCdpCommand(CDP) ---------------------
		 */

		ChromeDriver driver = new ChromeDriver();
		
		// create session between selenium code and chrome browser 
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String, Object> deviceMetrics = new HashMap<String, Object>();
		deviceMetrics.put("width", 600);
		deviceMetrics.put("height", 1000);
		deviceMetrics.put("deviceScaleFactor", 50);
		deviceMetrics.put("mobile", true);
		
		// direkter Aufruf DescriptionStrategy CDP-Commands, wenn kein Wrapper existiert
		// existiert ein Wrapper, wird devTools.send(Emulation.setDeviceMetricsOverride(...) verwendet
		// Parameter: 1. Name des Kommandos in "", 2. Parameter zum Ausführen des Kommandos
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		// auf das Burger-Menü klicken & aus dem Menü den Eintrag "Library" auswählen
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Library")).click();
		
		//driver.close();

	}

}
