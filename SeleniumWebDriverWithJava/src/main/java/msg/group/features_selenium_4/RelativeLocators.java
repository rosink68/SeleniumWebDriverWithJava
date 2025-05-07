package msg.group.features_selenium_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// 1. WebElement für Eingabelfeld für den Namen ermitteln
		WebElement nameEditField = driver.findElement(By.cssSelector("[name='name']"));
		// 2. das Label über dem Eingabefeld ermitteln
		String nameLabel = driver.findElement(with(By.tagName("label")).above(nameEditField)).getText();
		System.out.println(nameLabel);
		
		WebElement dateofBirthLabel = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		// Flex-Komponenten werden von den Relativen Locators nicht unterstützt
		// da das Eingabefeld vom Geburtstag eine Flex-Komponente ist, wird das nächste
		// Element mit dem <input>- Tag genommen <== hier der Submit-Button
		driver.findElement(with(By.tagName("input")).below(dateofBirthLabel)).click();
		
		
		WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
		
		WebElement radiobuttonStudent = driver.findElement(By.id("inlineRadio1"));
		String rbStudentLabel = driver.findElement(with(By.tagName("label")).toRightOf(radiobuttonStudent)).getText();
		System.out.println(rbStudentLabel);
	}

}
