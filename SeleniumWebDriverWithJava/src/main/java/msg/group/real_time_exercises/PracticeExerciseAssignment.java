package msg.group.real_time_exercises;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PracticeExerciseAssignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// 1. Select any checkbox 
		driver.findElement(By.id("checkBoxOption2")).click();

		// 2. Grab the label of selected checkbox
		String selectedOption = driver.findElement(By.xpath("//div [@class='right-align']/fieldset/label[2]")).getText().trim();
		
		// 3. Select an option in dropdown. The option to select should come from step 2.
		//driver.findElement(By.xpath("//option[contains(text(), '" + selectedOption + "')]")).click();
		// alternativ
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(selectedOption);
		
		// 4. Enter the step 2 grapped label text in the editbox "Switch To Alert Example"
		driver.findElement(By.id("name")).sendKeys(selectedOption);
		
		// 5. Click "Alert" button and then verify if the text grabbed from step 2 is present in the popup message.
		driver.findElement(By.id("alertbtn")).click();
		Alert alert = driver.switchTo().alert();	
		String textAlert = alert.getText();
		alert.accept();
		
		Assert.assertTrue(textAlert.contains(selectedOption));
		
		//driver.quit();
	}

}
