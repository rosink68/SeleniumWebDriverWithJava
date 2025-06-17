package oopbasics1.NestedLoops;

public class NestedLoops {

	public static void main(String[] args) {
		
		for ( int i=0; i<=4; i++) { // (outer for loop) this block will loop for 4 times
			
			System.out.println("outer loop started");
			
			for(int j=1; j<=4; j++) { // inner for loop
				System.out.println("inner loop");
			}
			System.out.println("outer loop ended");
		}
	}
}
