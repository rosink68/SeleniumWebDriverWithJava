package msg.group.basics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {
	
	// BeforeClass wird zu Beginn dieser Klasse ausgeführt
	@BeforeClass 
	public void beforeClassDay3() {
		System.out.println("-- I will execute before all methods in the day3 class");
	}
	
	// AfterClass wird am Ende dieser Klasse ausgeführt
	@AfterClass 
	public void afterClassDay3() {
		System.out.println("-- I will execute after all methods in the day3 class");
	}
	
	// BeforeMethod wird vor jeder Methode NUR von dieser Klasse ausgeführt
	@BeforeMethod 
	public void beforeEvery() {
		System.out.println("--- I will execute before every test method in day3 class");
	}
	
	// AfterMethod wird nach jeder Methode NUR von dieser Klasse ausgeführt
	@AfterMethod 
	public void afterEvery() {
		System.out.println("--- I will execute after every test method in day3 class");
	}

	// BeforeSuite muss nur in einer Klasse definiert werden und gilt für alle test
	// in der testng.xml, die im <suite>-Tag aufgelistet sind
	@BeforeSuite
	public void beforeSuiteLoanDepartment() {
		System.out.println("I am No 1");
	}

	// URL ist im testNG.xml definiert
	@Parameters({"URL", "APIKey/usrname"})
	@Test
	public void webLoginCarLoan(String urlName, String key) {
		
		// selenium
		System.out.println("weblogin car loan");
		System.out.println("Car Loan URL ====> " + urlName);
		System.out.println("Car Loan APIKey/usrname ====> " + key);
	}

	@Test(groups = {"Smoke"})
	public void mobileLoginCarLoan() {
		
		// Appium		
		System.out.println("mobile login car");
	}

	// eanabled = false bedeutet, dass der Test während der Testausführung übersprungen
	// wird, d.h. er wird nicht ausgeführt
	@Test(enabled = false)
	public void mobileSignInCarLoan() {
		
		// Appium		
		System.out.println("mobile sign in car");
	}

	// die Daten kommen vom DataProvider "getData"
	// getData liefert für jeden Testrun 2 Values: Username und Passwort
	@Test(dataProvider = "getData")
	public void mobileSignOutCarLoan(String username, String password) {
		
		// Appium		
		System.out.println("mobile sign out car");
		System.out.println("Username ====> " + username);
		System.out.println("Passwort ====> " + password);
	}

	// dependsOnMethods = {"webLoginCarLoan"} bedeutet, dass die Methode loginAPICarLoan
	// von der Methode webLoginCarLoan abhängt und erst danach ausgeführt werden kann
	@Test(dependsOnMethods = {"webLoginCarLoan"})
	public void loginAPICarLoan() {
		
		// Rest API
		System.out.println("login API car");
	}

	// Abbruch der Methode nach 4000 ms <== 4000 ms warten bevor der Test fehlschlägt
	@Test(timeOut = 4000)
	public void logoutAPICarLoan() {
		
		// Rest API
		System.out.println("logout API car");
	}
	
	@DataProvider
	public Object[][] getData() {
		
		// Multidimensionales Array definieren
		// Parameter: 
		// 1. [] - row besagt, wie oft der Test laufen soll
		// 2. [] - column besagt, wie viele Daten/Werte für jeden Test (row) verarbeitet werden
		Object[][] data = new Object[3][2];
		// 1. Zeile/Test: 1. Wert = Username, 2. Wert = Passwort
		data[0][0] = "firstsetusername";
		data[0][1] = "firstsetpassword";

		// 2. Zeile/Test
		data[1][0] = "secondsetusername";
		data[1][1] = "secondsetpassword";

		// 3. Zeile/Test
		data[2][0] = "thirdsetusername";
		data[2][1] = "thirdsetpassword";

		return data;
	}
}
