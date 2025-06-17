package chromeDevToolsFeatures;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v136.fetch.Fetch;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		
		// create session between selenium code and chrome browser 
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		// Fetch Domain: Domäne, mit der Clients die Netzwerkschicht des Browsers durch Clientcode ersetzen können.
		// https://chromedevtools.github.io/devtools-protocol/tot/Fetch/
		
		// enablen des Network, damit von Selenium aus auf die Network Activity gehört werden kann
		// Parameter (optional): 1. patterns - empty bedeutet, auf alle Request hören, 2. handleAuthRequests
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		// Fetch.requestPaused - Event wird fired, wenn irgendein Request zum Backend geschickt wird
		// anhalten des Request ==> Request modifizieren ==> zum Server weiterleiten/senden
		// Fetch.requestPaused() gibt ein Event zurück
		devTools.addListener(Fetch.requestPaused(), 
				request -> {
					
					// request modifizieren durch Zugriff auf den Request über getRequest()
					// https://chromedevtools.github.io/devtools-protocol/tot/Network/#type-Request
					
					// wenn die URL shetty enhält, shetty mit BadGuy ersetzen
					if (request.getRequest().getUrl().contains("shetty")) {
						
						String mockedUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
						System.out.println(mockedUrl);
						
						// Request weiter zum Server senden
						// https://chromedevtools.github.io/devtools-protocol/tot/Fetch/#method-continueRequest
						devTools.send(Fetch.continueRequest(
								request.getRequestId(), 
								Optional.of(mockedUrl), 	// geänderte URL
								Optional.of(request.getRequest().getMethod()),
								Optional.empty(), 
								Optional.empty(), 
								Optional.empty()));
					} else {
						
						// wenn shetty nicht enthalten ist ==> Request-URL unveränderte weitergeben
						devTools.send(Fetch.continueRequest(
								request.getRequestId(), 
								Optional.of(request.getRequest().getUrl()), // Ursprungs-URL
								Optional.of(request.getRequest().getMethod()),
								Optional.empty(), 
								Optional.empty(),
								Optional.empty()));
					}
				});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		Thread.sleep(3000);
		
		// wenn nur ein Buch gefunden wird, wird der Text "Oops only 1 Book available" angezeigt
		// NoSuchElementException bei mehreren Büchern in der Liste <== müsste gefixt werden
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		
		driver.close();
	}
}
