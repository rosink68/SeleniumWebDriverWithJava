package msg.group.objectorientedprinciples;

import org.testng.annotations.*;

// Parent class
public class PS {

	@BeforeMethod
	public void beforeRun() {
		System.out.println("Run me first");
	}

	public void doThis() {
		System.out.println("I am here.");
	}

	@AfterMethod
	public void afterRun() {
		System.out.println("Run me last");
	}
}
