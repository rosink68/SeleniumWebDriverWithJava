package msg.group.techniques_to_automate_webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SearchForAFlight {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


		// radiobutton "One Way" <== disabled calendar "RETURN DATE"
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

		
		// dropdown "FROM"
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();

		Thread.sleep(2000);
		
		
		// dropdown "TO" 
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

		
		// calendar "DEPART DATE"
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

		// Abfragen, ob opacity = 0.5 ==> wenn ja, erscheint "RETURN DAY" als disabled
		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
			System.out.println("its disabled");
			Assert.assertTrue(true);
			
		// bei opacity = 1
		} else {
			Assert.assertTrue(false);
		}

		
		// open dropdown "PASSENGERS"
		WebElement passengersDropdown = driver.findElement(By.id("divpaxinfo"));
		passengersDropdown.click();

		Thread.sleep(2000);

		for (int i=1; i<5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();				
		}

		// click on "Done" button
		driver.findElement(By.id("btnclosepaxoption")).click();


		// dropdown "CURRENCY" 
		Select dropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		dropdown.selectByIndex(3);

		
		// checkbox "Senior Citizen"
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();


		// click SEARCH button
		//driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		// alternativ mit cssSelector
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
	}

}
