package oopbasics2.ConstrustorAndKeywords;

// final Klasse können nicht als Parent verwendet werden
// class name as final - that means you cannot extend that class
public class FinalDemo {

	public static void main(String[] args) {
		
		// final - deklarieren einer Konstante, d.h. final Variable können nicht geändert werden
		final int i = 4; // constant variables
	}
	
	// final class cannot override in a child class
	final void getData() {
		
	}
	
}
