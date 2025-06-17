package chromeDevToolsFeatures;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v136.network.model.Request;
import org.openqa.selenium.devtools.v136.network.model.Response;
import org.openqa.selenium.devtools.v136.network.Network;

public class NetworkLogActivity {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		
		// create session between selenium code and chrome browser 
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		// https://chromedevtools.github.io/devtools-protocol/tot/Network/
		
		// Aktivieren der Netzwerkverfolgung, um Netzwerkereignisse an den Client zu übermitteln
		// Parameter (optional): 1. maxTotalBufferSize, 2. maxResourceBufferSize, 3. maxPostDataSize
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		
		// Wird ausgelöst, wenn die Seite im Begriff ist, eine HTTP-Anforderung zu senden
		// verarbeiten des Requests
		devTools.addListener(Network.requestWillBeSent(), 
				request -> {
					Request req = request.getRequest();
					System.out.println(req.getUrl());
					//req.getHeaders()
				});

		
		// Abfragen, welche Ereignisse (von API) ausgelöstet werden, wenn Browser eine Antwort vom Netzwerk empfängt
		// das Event Network.responseReceived wird ausgelöst, ermitteln der HTTP-Antwort & loggen der Infos
		// Parameter: 1. Event, auf das gehört wird 2. Consumer, d.h. die zurückgegebene Antwort
		devTools.addListener(Network.responseReceived(), 
				response -> {
					
					// Zugriff auf die Response-Klasse Network.Response() und ihre Details
					Response res = response.getResponse();

					//System.out.println(res.getUrl());
					//System.out.println(res.getStatus());	
					// nur loggen, wenn Test fehlschlägt
					if(res.getStatus().toString().startsWith("4")) {
						System.out.println(res.getUrl()+"is failing with status code"+res.getStatus());
					}
				});
		
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		// auf den Button "Virual Library" klickenen
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
	}

}
