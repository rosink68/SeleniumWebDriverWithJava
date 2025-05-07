package msg.group.basics;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {

	// BeforeTest muss nur in einer Klasse definiert werden und gilt für jede class
	// in der testng.xml, der im selben <test>-Tag aufgelistet ist
	@BeforeTest
	public void prerequiste() {
		System.out.println("- I will execute first from test named 'Personal loan'.");
	}
	
	@Test(groups = {"Smoke"})
	public void pLoan() {
		System.out.println("Day 2");
	}

}
