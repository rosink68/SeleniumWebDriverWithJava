package oopbasics1.Arrays;

public class Multidimensional {

	public static void main(String[] args) {
		
		// a[row][column] ([x-Achse][y-Achse]
		int a[][] = new int[2][3];
		
		// Bsp. 	2	4	5
		//			3	4	7
		a[0][0] = 2;
		a[0][1] = 4;
		a[0][2] = 5;
		a[1][0] = 3;
		a[1][1] = 4;
		a[1][2] = 7;
		
		// Ausgabe: 2. Zeile 1. Spalte ==> 3
		System.out.println(a[1][0]);
		
		// analog: gleich initieren
		// {} - 1. Index 0, {} - 2. Index 1, {} - Index 2 neu
		int b[][] = {{2, 4, 5}, {3, 4, 7}, {5, 2, 1}};
		System.out.println(b[2][1]);
		
		System.out.println("--------------------------------");

		for(int x=0; x<2; x++) {	// row
			
			for(int y=0; y<3; y++) {	// column
				System.out.print(a[x][y] + " ");
			}
			System.out.println();
		}
	}
}
