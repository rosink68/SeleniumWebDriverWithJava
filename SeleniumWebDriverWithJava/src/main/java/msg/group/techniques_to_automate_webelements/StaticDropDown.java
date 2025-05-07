package msg.group.techniques_to_automate_webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// dropdown "CURRENCY" with select tag means static dropdown <== d.h. die options ändern sich nicht!!!
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		// dropdown "CURRENCY" is a single select option <== d.h. es kann nur immer eine Option ausgewählt werden 
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText()); 
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText()); 
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText()); 
		
		driver.quit();
		
	}
}
