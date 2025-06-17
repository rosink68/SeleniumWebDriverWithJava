package chromeDevToolsFeatures;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v136.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequests {

	public static void main(String[] args) throws InterruptedException {
		
		/**
		 * Blockieren z.Bsp. des Ladens von Bildern oder CSS, damit die 
		 * Webseite schneller geladen wird.
		 */
		
		ChromeDriver driver = new ChromeDriver();
		
		// create session between selenium code and chrome browser 
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		// Network Domain: um Netzwerkaktivitäten zu tracken
		// https://chromedevtools.github.io/devtools-protocol/tot/Network/

		// enablen des Network, damit von Selenium aus auf die Network Activity gehört werden kann
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		// Blockieren einer URL beim Laden
		// https://chromedevtools.github.io/devtools-protocol/tot/Network/#method-setBlockedURLs
		// Parameter: Liste von URLs, die geblockt werden sollen <== ImmutableList - Liste, deren 
		// Inhalt nach der Erstellung nicht mehr geändert werden kann
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", ".css")));

		
		long startTime = System.currentTimeMillis();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();

		driver.findElement(By.linkText("Selenium")).click();
		
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText()); 

		long endTime = System.currentTimeMillis();

		System.out.println(endTime-startTime);
		
		driver.close();
	}
}
