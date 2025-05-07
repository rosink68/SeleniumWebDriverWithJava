package msg.group.real_time_exercises;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderUI {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String month = "6";
		String day = "15";
		String year = "2027";
		String[] expectedList = {month, day, year};
		
		driver.findElement(By.className("react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		// 2. Klick, um zur Auflistung der Jahre zu kommen
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		
		// 2027 auswählen
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		
		// June auswählen
		List<WebElement> allMonth = driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"));
		allMonth.get(Integer.parseInt(month) - 1).click();
//		for (int i=0; i<allMonth.size(); i++) {
//			if (i+1 == Integer.parseInt(month)) {
//				allMonth.get(i).click();
//				break;
//			}
//		}
		
		// 15 auswählen
		driver.findElement(By.xpath("//abbr[text()='" + day + "']")).click();
		
		
		
		// Assertion: prüfen, ob das richtige Datum ausgewählt wurde
		
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for (int i=0; i<actualList.size(); i++) {
			Assert.assertEquals(actualList.get(i).getDomAttribute("value"), 
					expectedList[i]);
			
		}
		
		driver.quit();
	}

}
