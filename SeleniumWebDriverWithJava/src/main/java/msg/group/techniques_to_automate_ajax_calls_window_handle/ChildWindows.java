package msg.group.techniques_to_automate_ajax_calls_window_handle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ChildWindows {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.className("blinkingText")).click();
		
		// Abfragen, wie viele Windows/Tabs geöffnet sind
		// windows enthält die ID vom Parent und vom Child: [parentid, childid]
		Set<String> windows = driver.getWindowHandles(); 
		
		// IDs ermitteln
		Iterator<String> iter = windows.iterator();
		String parentId = iter.next(); 	// 1. Element im windows-Set <== Index [0]
		String childId = iter.next();	// 2. (nächste) Element <== Index [1]
		
		// zum Childwindow wechseln
		driver.switchTo().window(childId);
		
		// den roten Text "Please email us at mentor@rahulshettyacademy.com with below template to receive response" 
		// ermitteln und daraus die Mailadresse extrahieren
		String redText = driver.findElement(By.cssSelector(".im-para.red")).getText();
		String emailId = redText.split("at")[1].trim().split(" ")[0];
		Assert.assertEquals(emailId, "mentor@rahulshettyacademy.com");
		
		// zum Parentwindow zurückkehren
		driver.switchTo().window(parentId);
		
		// Mailadresse in das Feld Username einfügen
		driver.findElement(By.id("username")).sendKeys(emailId);
		
	}

}
