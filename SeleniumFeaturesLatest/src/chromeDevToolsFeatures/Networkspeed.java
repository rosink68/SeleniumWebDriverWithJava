package chromeDevToolsFeatures;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v136.network.Network;
import org.openqa.selenium.devtools.v136.network.model.ConnectionType;

public class Networkspeed {

	public static void main(String[] args) {
		
		// Reduzieren der Netzwerkgeschwindigkeit <== Geschwindigkeit nachahmen
		// https://chromedevtools.github.io/devtools-protocol/tot/Network/#method-emulateNetworkConditions
		
		// Parameter Network.emulateNetworkConditions: 
		// 1. offline -True, um eine Internetunterbrechung zu emulieren (false - bedeutet KEINE Internetverbindung!)
		// 2. latency - Minimale Latenz vom Senden der Anfrage bis zum Empfangen der Antwortheader (ms)
		// 3. downloadThroughput - Maximaler aggregierter Download-Durchsatz (Bytes/Sek.). -1 deaktiviert die Download-Drosselung
		// 4. uploadThroughput - Maximaler aggregierter Upload-Durchsatz (Bytes/Sek.). -1 deaktiviert die Upload-Drosselung
		// 5. - 8. optional
		
		ChromeDriver driver = new ChromeDriver();
		
		// create session between selenium code and chrome browser 
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		// enablen des Network, damit von Selenium aus auf die Network Activity gehört werden kann
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		// mit emulateNetworkConditions dauert das Laden 14808 und ohne 1420 
		devTools.send(Network.emulateNetworkConditions(
				false, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET), 
				Optional.of(0), Optional.of(0), Optional.of(true)));
		
		// Ausgabe, warum das Laden fehlschlägt <== wenn 1. Parameter - true 
		// Ausgabe:
		// net::ERR_INTERNET_DISCONNECTED
		// 30647.349073
//		devTools.send(Network.emulateNetworkConditions(
//				true, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET), 
//				Optional.of(0), Optional.of(0), Optional.of(true)));

		devTools.addListener(Network.loadingFailed(), 
				loadingFailed -> {
					System.out.println(loadingFailed.getErrorText());
					System.out.println(loadingFailed.getTimestamp());
				});
		
		long startTime = System.currentTimeMillis();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

		long endTime = System.currentTimeMillis();

		System.out.println(endTime-startTime);
		
		//driver.close();


	}

}
