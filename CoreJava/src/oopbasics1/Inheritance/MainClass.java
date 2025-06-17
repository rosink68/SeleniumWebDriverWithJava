package oopbasics1.Inheritance;

public class MainClass {

	public static void main(String[] args) {
		
		A a = new B();
		System.out.println("A a = new B(): " + a.i);

		B b = new B();
		System.out.println("B b = new B(): " + b.i);
		
		/**
		 * Zum Beispiel initieren wird en Chromedriver, 
		 * nutzen aber die Methoden vom WebDriver
		 */
		//WebDriver driver = new ChromeDriver();
	}

}
