package oopbasics1.Arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		
		// Array: store multiple values of same data type in a single container
		
		// declares an array and allocates memory for the values
		int a[] = new int[5];		
		
		// initialized values into array
		a[0] = 2;
		a[1] = 6;
		a[2] = 1;
		a[3] = 9;
		a[4] = 12;
		
		// retrieve values present in that array
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		
		System.out.println("--------------------------------");
		
		int b[] = {1, 4, 3, 5, 7, 8};
		for(int i=0; i<b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
