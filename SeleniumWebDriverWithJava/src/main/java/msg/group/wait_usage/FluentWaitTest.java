package msg.group.wait_usage;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class FluentWaitTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		// nach Klick auf den Start-Button erscheint erst ein Ladebalken und 
		// dann an der gleichen Position der Text "Hello World!"
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		
		// Waiting 30 seconds for an element to be present on the page, checking
  	   	// for its presence once every 5 seconds.
		// withTimeout - Zeit, nach der mit fail abgebrochen wird
		// pollingEvery - Zeit, in der nachgeschaut wird, ob das Element angezeigt wird 
		// ignoring - wenn in der Zeit eine NoSuchElementException auftritt, soll sie ignoriert werden
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		
		// FluentWait hat keine vordefinierten Funktionen wie visibilityOfElementLocated
		// ==> die Funktion muss selber definiert werden


		// warten, bis die apply-Methode ein WebElement zurückgibt
		// "Hello World!" wird erst angezeigt, wenn der Loading... Balken verschwunden ist
		// 30s (withTimeout) wird alle 3s (pollingEvery) versucht, 
		// ob das WebElement "Hello World!" schon angezeigt wird
		// Abbruch, wenn "Hello World!" gefunden wurde oder die Timeout-Zeit (d.h. fail) erreicht ist
		WebElement helloWorldElement = wait.until(new Function<WebDriver, WebElement>() {
		     
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.cssSelector("div[id='finish'] h4"));
				// erst wenn das WebElement sichtbar ist, kann es zurückgegeben werden
				if (element.isDisplayed()) {
				    return element;					
				} else {
					return null;
				}
		     }
		});
		
		Assert.assertEquals(helloWorldElement.getText(), "Hello World!");
		
		driver.quit();
	}

}
