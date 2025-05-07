package msg.group.techniques_to_automate_webelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropDowns {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// COUNTRY <== über die Eingabe von Zeichen wird die Ergebnisliste reduziert
		driver.findElement(By.id("autosuggest")).sendKeys("ger");
		Thread.sleep(3000);
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
	
		for (WebElement option : options) {
			// looking for "Germany" and clicking
			if (option.getText().equalsIgnoreCase("Germany")) {
				option.click();
				break;
			}		
		}
	}

}
