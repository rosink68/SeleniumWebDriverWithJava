package chromeDevToolsFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v136.fetch.Fetch;
import org.openqa.selenium.devtools.v136.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v136.network.model.ErrorReason;

public class NetworkFailRequest {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		
		// create session between selenium code and chrome browser 
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		// Fetch Domain: Domäne, mit der Clients die Netzwerkschicht des Browsers durch Clientcode ersetzen können.
		// https://chromedevtools.github.io/devtools-protocol/tot/Fetch/

		// enablen des Network, damit von Selenium aus auf die Network Activity gehört werden kann
		// Parameter (optional): 1. patterns - fängt alles mit *GetBook* in der URL hat, 2. handleAuthRequests
		Optional<List<RequestPattern>> patterns = Optional.of(Arrays.asList(new RequestPattern(
				Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));
		devTools.send(Fetch.enable(patterns, Optional.empty()));

		// Request anhalten ==> ändern ==> weitersenden 
		devTools.addListener(Fetch.requestPaused(), 
				request -> {
					// nur request mit GetBook kommen hier an und soll fehlschlagen

					// https://chromedevtools.github.io/devtools-protocol/tot/Fetch/#method-failRequest
					// Parameter: 1. welcher Request fehlschlagen soll; 2. warum er fehlschlagen soll (Grund)
					devTools.send(Fetch.failRequest(
							request.getRequestId(), 
							ErrorReason.FAILED));
				});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		Thread.sleep(3000);
		
		// hier: wird kein Ergebnis angezeigt, ABER normalerweise wird eine Fehlernachricht angezeigt (hier nicht implementiert!!!)
	}
}
