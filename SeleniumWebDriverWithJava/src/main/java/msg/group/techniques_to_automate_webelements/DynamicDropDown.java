package msg.group.techniques_to_automate_webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// dropdown "FROM"
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		// //a[@value='BLR'] - xpath for Bengaluru (BLR) 
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		// im div-Parent wird der entsprechende a-Tag gesucht <== hier nicht notwendig, da immer das 1. gefundene Element genommen wird
		//driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		
		Thread.sleep(2000);
		
		// dropdown "TO" 

		/**
		 * Lösung 1: mit Index
		 */

		// (//a[@value='MAA'])[2] - xpath for Chennai (MAA) 
		// ==> [2] weil es 2 Treffer gibt und sonst der 1. in "FROM" genommen wird
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		/**
		 * Lösung 2: mit Parent 
		 */

		// dropdown "TO" 
		// im div-Parent wird der entsprechende a-Tag gesucht
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

	}

}
