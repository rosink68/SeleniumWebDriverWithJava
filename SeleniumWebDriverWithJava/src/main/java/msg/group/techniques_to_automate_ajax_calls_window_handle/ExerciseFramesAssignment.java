package msg.group.techniques_to_automate_ajax_calls_window_handle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciseFramesAssignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");

		// open window
		driver.findElement(By.linkText("Nested Frames")).click();

		// in den äußeren Frame wechseln
		//WebElement outerFrame = driver.findElement(By.cssSelector("frame[name='frame-top']"));
		//driver.switchTo().frame(outerFrame);	
		// switch über den Namen des Framewindows
		driver.switchTo().frame("frame-top");
	
		// in den mittleren (inneren) Frame wechseln
		//WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		//driver.switchTo().frame(middleFrame);
		// switch über den Namen des Framewindows
		driver.switchTo().frame("frame-middle");
		
		String middleText = driver.findElement(By.id("content")).getText();
		System.out.println(middleText);
		
		driver.switchTo().defaultContent();
		
		driver.quit();
	}

}
