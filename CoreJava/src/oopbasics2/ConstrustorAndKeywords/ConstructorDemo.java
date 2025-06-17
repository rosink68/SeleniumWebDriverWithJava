package oopbasics2.ConstrustorAndKeywords;

public class ConstructorDemo {

	// will not return values
	// name of constructor should be class name
	// block of code when ever an object is created
	// if vou have not defined constructor block, complier will call default (implicit) constructor 
	
	// wenn kein Default-Konstruktor explizit definiert ist, aber ein parametrisierter 
	// Konstruktor und es wird versucht, den Default-Konstruktor aufzurufen, wird ein Error angezeigt
	
	// default constructor
	public ConstructorDemo() {
		System.out.println("I am in the constructor");
		
	}
	

	// parameterized constructor

	public ConstructorDemo(int a, int b) {
		System.out.println("I am in the parameterized constructor");
		System.out.println(a+b);
		
	}

	public ConstructorDemo(String str) {
		System.out.println(str);
		
	}

	
	public void getData() {
		System.out.println("I am in the method");
	}
	
	public static void main(String[] args) {
		
		// when ever vou create an object constructor is called but not the method
		// wenn kein Konstruktor definiert wurde, wird der Default-Konstruktor aufgerufen
		ConstructorDemo cd = new ConstructorDemo();
		
		ConstructorDemo cdp1 = new ConstructorDemo(5, 9);
		ConstructorDemo cdp2 = new ConstructorDemo("hello");
		
	}

}
