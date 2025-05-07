package msg.group.techniques_to_automate_ajax_calls_window_handle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTechniquesDemo {

	public static void main(String[] args) {
		
		/**
		 * Aufgaben: Das linkes Quadrat per Drag & Drop ins rechte graue Quadrat 
		 * verschieben.
		 * 
		 * Die Quadrate sind in einem Frame eingebettet! 
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		// zum Frame wechseln <== wenn man den Index zum Wechseln nimmt,
		// sollte vorher geprüft werden, wie viele iFrames es gibt
		System.out.println("Anzahl iFrames: " + driver.findElements(By.tagName("iFrame")).size());
		//driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		// linkes Quadrat (Quelle), rechtes Quadrat (Ziel)
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).build().perform();
		
		// zurück zum Window wechseln
		driver.switchTo().defaultContent();
	}
}
