package chromeDevToolsFeatures;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v134.emulation.Emulation;


public class MobileEmulatorTest {

	public static void main(String[] args) throws Exception {
		
		/**
		 * Fluss der Kommandos
		 * 
		 * WebDriver ---> send(Command) ---> Selenium Server 	 ---> Chrome DevTools Protocol (CDP)
		   Code							 	 Interprets Commands				^
		   		|																|
		   		-------------------- executeCdpCommand(CDP) ---------------------
		 */
		
		// ChromeDriver nutzen, wenn man auf die Chrome Dev Tools zugreifen will
		// ChromeDriver & SdgeDriver sind ChromiumDriver (seit Selenium 4)
		ChromeDriver driver = new ChromeDriver();
		
		// Objekt für Chrome Dev Tools erzeugen <== allows to send() the 
		//built-in Selenium commands for CDP (Chrome DevTools Protocol)
		DevTools devTools = driver.getDevTools();
		
		// create session between selenium code and chrome browser 
		devTools.createSession();

		
		// danach können erst CDP-Methoden ausgeführt werden
		// send commands to CDP Methods ==> CDP Methods will invoke
		// and get access to chrome dev tools <== keine direkter Zugriff, sondern über CDP Methods
		
		// Emulation Kommandos auf https://chromedevtools.github.io/devtools-protocol/tot/Emulation/
		// Emulation bedeutet, der Browser simuliert iPad, iPhone, Anroid ...
		
		// setDeviceMetricsOverride - überschreiben der Werte der Gerätebildschirmabmessungen
		// Default - ganzer Bildschirm
		// Parameter: 1. Breite in Pixel, 2. Höhe in Pixel, 
		// 3. deviceScaleFactor - Zoomfaktor, 4. true - Anzeige in a mobile view, 
		// ab 5. optional, d.h. die Parameter können leer (Optional.empty()) sein 
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, 
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), 
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), 
				Optional.empty(), Optional.empty()));

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		// auf das Burger-Menü klicken & aus dem Menü den Eintrag "Library" auswählen
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Library")).click();
		
		//driver.close();
	}

}
