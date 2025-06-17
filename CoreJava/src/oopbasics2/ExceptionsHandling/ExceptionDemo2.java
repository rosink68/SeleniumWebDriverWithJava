package oopbasics2.ExceptionsHandling;

// one try can be followed by multiple catch blocks 
// catch should be an immediate block after try
public class ExceptionDemo2 {

	public static void main(String[] args) {
		
		int b = 7;
		int c = 0;
		
		// für jede Exception kann eine eigener catch-Block geschrieben werden
		try {
			// erzeugen einer ArithmeticException
//			int k = b/c;
//			System.out.println(k);
			
			// erzeugen einer IndexOutOfBoundsException
			int arr[] = new int[5];
			System.out.println(arr[7]);
			
		// speziefische Exceptions
		} catch (ArithmeticException ae) {
			System.out.println("I catched the Arithmetic exception");

		} catch (IndexOutOfBoundsException be) {
			System.out.println("I catched the IndexOutOfBound exception");
	
		// allgemeine Exception <== Exception ist die Parentklasse aller Exceptions
		} catch (Exception e) {
			System.out.println("I catched the error/exception");
			System.out.println(e.toString());
		}
		
		// this block is executed irrespective of exception thrown or not
		finally {
			// der finally-Block wird (nur) immer ausgeführt, wenn der Test fehlschlägt 
			// <== nicht bei erfolgreicher Ausführung oder wenn Ausführung gestoppt wird
			System.out.println("finally-Block: Delete cookies");
		}
	}
}
