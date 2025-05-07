package msg.group.miscellaneous_topics;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExploreChromeOptions {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		//options.addExtensions(<filename der extention>);
		
		// Proxy setzen
		//Proxy proxy = new Proxy();
		//proxy.setHttpProxy(<ipadresse vom proxy>);
		//options.setCapability("proxy", true);
		
		// Blocken von pop-up Windows
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		// Download-Verzeichnis setzen
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}
}
