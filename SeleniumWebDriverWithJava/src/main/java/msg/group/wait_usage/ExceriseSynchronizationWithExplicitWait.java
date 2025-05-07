package msg.group.wait_usage;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ExceriseSynchronizationWithExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false); 
		Map<String, Object> profile = new HashMap<String, Object>();
		profile.put("password_manager_leak_detection", false);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Lpgin Page
		login(driver, wait);
		
		// Shop Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		int numProducts = addAllProductsToCart(driver, wait);
		WebElement checkoutButton = driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']"));
		String productsInCart = checkoutButton.getText().split(" ")[2];
		Assert.assertTrue(checkoutButton.getText().contains(Integer.toString(numProducts)), 
				numProducts + " products have been added but only " + productsInCart + " are in the cart.");
		
		checkoutButton.click();
		
		// Assertion Product List Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Total']")));
		List<WebElement> quantities = driver.findElements(By.xpath("//td[@class='col-sm-8 col-md-6']"));
		Assert.assertEquals(numProducts, quantities.size(), "Number of products is wrong.");

		
		driver.quit();
	}
	
	public static void login(WebDriver driver, WebDriverWait wait) {

		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		
		// Radiobutton "User" aktivieren und den Okay-Button klicken
		driver.findElement(By.xpath("//input[@value='user']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn"))).click();
		
		// aus der Combobox "Consultant" auswählen
		WebElement comboboxElement = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select selection = new Select(comboboxElement);
		selection.selectByValue("consult");
		
		driver.findElement(By.id("terms")).click();
		
		driver.findElement(By.id("signInBtn")).click();
	}

	public static int addAllProductsToCartDozent(WebDriver driver, WebDriverWait wait) {
		
		List <WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
		int j = 0;
		for(int i =0;i<products.size();i++) {
			products.get(i).click();
			j++;
		}
		return j;
	}

	public static int addAllProductsToCart(WebDriver driver, WebDriverWait wait) {
		
		int i = 0;
		List <WebElement> cards = driver.findElements(By.cssSelector(".card-footer .btn-info"));
		
		for (WebElement card : cards) {
			card.click();
			i++;			
		}
		
		return i;
	}
}
