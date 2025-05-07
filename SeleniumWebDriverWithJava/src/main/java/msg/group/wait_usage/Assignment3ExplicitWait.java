package msg.group.wait_usage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3ExplicitWait {

	static String AppUrl="https://rahulshettyacademy.com/loginpagePractise/";	
	static WebDriver driver;	
	
	public static void main(String[] args) throws InterruptedException {				
		//WebDriverManager.chromedriver().setup();		
		driver = new ChromeDriver();		
		String[] itemsNeeded= {"iphone X", "Samsung Note 8"};		
		driver.get(AppUrl);				
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");		
		driver.findElement(By.id("password")).sendKeys("learning");		
		driver.findElement(By.xpath("//input[@value='user']")).click();		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));		
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='okayBtn']")));		
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		Select d = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));		
		d.selectByValue("consult");		
		System.out.println(d.getFirstSelectedOption().getText());		
		driver.findElement(By.id("terms")).click();		
		driver.findElement(By.id("signInBtn")).click();		
		Thread.sleep(3000);		
		addCart(driver,itemsNeeded);		
		//checkout		
		driver.findElement(By.xpath("//*[@id='navbarResponsive']/ul/li/a")).click();		
		//		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();		
		//checkbox 		
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//div[@class='checkbox checkbox-primary']")).click();				
		driver.findElement(By.xpath("//input[@value='Purchase']")).click();		
	}				
	
	public static void addCart(WebDriver driver, String[] itemsNeeded) {						 
		int count = 0;			 
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-body']//a"));			  
		for (int i = 0; i < products.size(); i++) {			   
			for (int j = 0; j < itemsNeeded.length; j++) {				  
				if (products.get(i).getText().contains(itemsNeeded[j].toString())) {				   
					count++;				   
					driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();				   
					if (count == itemsNeeded.length)				   
						break;		
				}		
			}	   
		}
	}
}
