package oopbasics2.ExceptionsHandling;

public class ExceptionDemo {

	public static void main(String[] args) {
		
		int b = 7;
		int c = 0;
		
		// ohne try-catch-Block wird eine "java.lang.ArithmeticException: / by zero" 
		// geworfen und das Programm bricht ab
		try {
			int k = b/c;
			System.out.println(k);
			
		} catch (Exception e) {
			System.out.println("I catch the error/exception");
			System.out.println(e.toString());
		}
	}
}
