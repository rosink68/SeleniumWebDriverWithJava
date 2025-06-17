package oopbasics1.Arrays;

public class PracticeExercise_PrintSmallestNumberInMatrix {

	public static void main(String[] args) {
		
		/**
		 * Aufgabe: Aus dem Array die kleinste Nummer ermitteln.
		 * 
		 * 8 4 5
		 * 3 2 10
		 * 11 2 0
		 */
		int a[][] = {{8, 4, 5}, {3, 2, 10}, {11, 2, 0}};

		int min = a[0][0];	// Initialisieren mit 1. Array-Element
		int colMin = 0;
		
		for(int x=0; x<3; x++) {	// row
			
			for(int y=0; y<3; y++) {	// column
				
				if (a[x][y] < min) {
					min = a[x][y];
					colMin = y;
				} 	
			}
		}
		
		// Initialisieren mit 1. Wert der Spalte, in der das Minimum gefunden wurde
		int max = a[0][colMin];	
		int k = 0; 
		// alle 3 Rows durchlaufen
		while(k<3) {
			if (a[k][colMin] > max) {
				max = a[k][colMin];
			} 		
			k++;
		}
		
		System.out.println("minimum number is " + min);
		System.out.println("maximum number in the column with mininmum number is " + max);
	}
}
