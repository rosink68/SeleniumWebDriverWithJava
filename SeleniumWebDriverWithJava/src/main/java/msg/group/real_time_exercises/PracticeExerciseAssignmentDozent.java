package msg.group.real_time_exercises;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeExerciseAssignmentDozent {
	
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();

		String opt=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();

		WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));

		Select s=new Select(dropdown);
		s.selectByVisibleText(opt);

		driver.findElement(By.name("enter-name")).sendKeys(opt);

		driver.findElement(By.id("alertbtn")).click();

		String text=  driver.switchTo().alert().getText();
		if(text.contains(opt)) {
			System.out.println("Alert message success");
		} else
			System.out.println("Something wrong with execution");
		}
}
