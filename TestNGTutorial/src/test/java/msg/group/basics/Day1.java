package msg.group.basics;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Day1 {

	// AfterSuite muss nur in einer Klasse definiert werden und gilt für alle test
	// in der testng.xml, die im <suite>-Tag aufgelistet sind
	@AfterSuite
	public void afterSuiteLoanDepartment() {
		System.out.println("I am the No 1 from last");
	}

	// AfterTest muss nur in einer Klasse definiert werden und gilt für jede class
	// in der testng.xml, der im selben <test>-Tag aufgelistet ist
	@AfterTest
	public void lastExecution() {
		System.out.println("- I will execute last from test named 'Personal loan'");
	}

	@Test
	public void firstDemo() {
		System.out.println("First Test");
		Assert.assertTrue(false);
	}
	
	@Test
	public void secondTest() {
		System.out.println("Second Test");
	}
	
}
