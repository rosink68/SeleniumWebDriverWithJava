package msg.group.basics;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {
	
	@Test(groups = {"Smoke"})
	public void webLoginHomeLoan() {
		
		// selenium
		System.out.println("weblogin home");
	}

	// URL ist im testNG.xml definiert
	@Parameters({"URL"})
	@Test
	public void mobileLoginHomeLoan(String urlName) {
		
		// Appium		
		System.out.println("mobile login home - Personal Loan");
		System.out.println("Personal Loan URL ====> " + urlName);
	}

	@Test
	public void loginAPIHomeLoan() {
		
		// Rest API
		System.out.println("login API home");
	}
}
