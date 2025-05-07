package msg.group.miscellaneous_topics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingHTTPSCertificationsInAutomatedBrowsers {

	public static void main(String[] args) {
		
		/**
		 * Funktioniert nicht, da die Webseite von msg geblockt wird!!!
		 */
		
		//SSl certificates
		
		ChromeOptions options = new ChromeOptions();
		// Akzeptieren von Zertifikaten
		options.setAcceptInsecureCerts(true);

		WebDriver driver=new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		
		System.out.println("Title of page: " + driver.getTitle());
		

	}

}
