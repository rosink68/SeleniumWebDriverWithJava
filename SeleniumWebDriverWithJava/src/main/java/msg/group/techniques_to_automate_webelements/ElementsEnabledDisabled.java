package msg.group.techniques_to_automate_webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ElementsEnabledDisabled {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// dropdown "FROM"
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();

		Thread.sleep(2000);
		
		// dropdown "TO" 
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

		// calendar "DEPART DATE"
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
	
		// radiobutton "Round Trip" <== enabled calendar "RETURN DATE"
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		// calendar "RETURN DAY"
		// da auf der Webseite "RETURN DAY" nicht en- bzw. disabled wird, sondern mit
		// dem Styleattribute "opacity", fragen wir dieses ab:
		// opacity: 0.5 - sieht aus wie disabled
		// opacity: 1  	- sieht aus wie enabled
		//driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled();
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		
		// Abfragen, ob opacity = 1 ==> wenn ja, erscheint "RETURN DAY" als enabled
		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
			System.out.println("its enabled");
			Assert.assertTrue(true);
			
		// bei opacity = 0.5
		} else {
			Assert.assertTrue(false);
		}
		
		driver.quit();
	}

}
