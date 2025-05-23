package msg.group.practical_problems_javascriptexecutor;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciseWebTablesAssignmentDozent {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");

		WebElement table=driver.findElement(By.id("product"));

		System.out.println(table.findElements(By.tagName("tr")).size());
	
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		
		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());	
	}
}
