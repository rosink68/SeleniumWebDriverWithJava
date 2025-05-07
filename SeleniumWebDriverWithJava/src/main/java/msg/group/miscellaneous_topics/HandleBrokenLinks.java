package msg.group.miscellaneous_topics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class HandleBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {

		WebDriver driver = new ChromeDriver();
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/"); <== FUNKTIONIERT NICHT!!!
		driver.get("https://omayo.blogspot.com/");
		
		// brokenLinks bedeutet brokenURL, d.h. die Webseite wird nicht aufgerufen

		// alle URLs zu den Links ermitteln <== auf Links in einer Liste "li a" 
		List<WebElement> links= driver.findElements(By.cssSelector("a"));
	  	
		SoftAssert a = new SoftAssert();
		
		// alle URL aufrufen und den Statuscode prüfen 
		
		for (WebElement link : links) {

			String url = link.getDomProperty("href");
			// # am Ende entfernen
			url = url.split("#")[0].trim();
			System.out.println("XX" + url + "XX");
					
			// URL.Connection-Klasse anwenden, um die URL zu prüfen
			// d.h. die URL wird zum Internet gesendet und der Response zurückgegeben
			// openConnection() ist eine Methode der URL-Klasse ==> deshalb muss ein Objekt 
			// von der Klasse erzeugt werden <== returns URLConnection bzw. 
			// die Parentklasse HttpURLConnection ==> casten
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			// Request mit dem Typ HEAD machen
			conn.setRequestMethod("HEAD");
			conn.connect();

			// wenn der Statuscode > 400 ==> broken Link (z.B. 404)
			// Response-Code ermitteln
			int respCode = conn.getResponseCode();
			System.out.println(respCode);

			// wenn der Response > 400, dann ist es ein abgebrochener Link
			a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
		}

		// Ausführen der Softassertion, d.h. validiert alle Links
		a.assertAll();
		
		driver.quit();
		
	}

}
