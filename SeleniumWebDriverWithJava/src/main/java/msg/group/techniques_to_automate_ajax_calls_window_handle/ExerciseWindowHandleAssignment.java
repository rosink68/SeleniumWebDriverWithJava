package msg.group.techniques_to_automate_ajax_calls_window_handle;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExerciseWindowHandleAssignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		// open new window <== new parent window
		driver.findElement(By.linkText("Multiple Windows")).click();
		
		// open child window
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='example'] a"))).click();
		
		// determine window handles
		// Index=0 - new parent window; Index=1 - child window
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parentId = iter.next();
		String childId = iter.next();		
		
		// move to child window
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		// move back to parent window
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		driver.quit();		
	}

}
