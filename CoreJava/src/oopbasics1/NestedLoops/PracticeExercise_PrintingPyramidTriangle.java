package oopbasics1.NestedLoops;

public class PracticeExercise_PrintingPyramidTriangle {

	public static void main(String[] args) {
		
		/**
		 * Aufgabe mit innerer und äußerer for-Schleife lösen.
		 * 
		 * Ausgabe: 
		 * 4x äußere Schleife und dann in der inneren Schleife die Variable der äußeren Schleife
		 * von der Variable der inneren Schleife abziehen.
		 * Für die auszugebenen Zahlen wird eine eigene Variable benutzt.
		 * 1 2 3 4 
		 * 5 6 7
		 * 8 9
		 * 10
		 */

		int k = 1;
		// 4 Zeilen
		for ( int i=0; i<4; i++) { 
			
			// j immer um i reduzieren
			for(int j=1; j<=4-i; j++) { // inner for loop
				System.out.print(k + "\t");
				k++;
			}
			
			System.out.println();
		}
		
		System.out.println("=============================================");
		
		/**
		 * Inverted sequence pyramid logic program.
		 * 4x äußere Schleife und dann die Variable der inneren Schleife mit der Variablen 
		 * der äußeren Schleife belegen.
		 * Für die auszugebenen Zahlen wird eine eigene Variable benutzt.
		 * 
		 * Ausgabe:
		 * 1
		 * 2 3
		 * 4 5 6
		 * 7 8 9 10
		 */
		
		k = 1;
		// 4 Zeilen
		for ( int i=1; i<5; i++) { 
			
			// j ist immer i
			for(int j=1; j<=i; j++) { // inner for loop
				System.out.print(k + "\t");
				k++;
			}
			
			System.out.println();
		}
		
		System.out.println("=============================================");
		
		/**
		 * Inverted sequence pyramid logic program.
		 * 4x äußere Schleife und dann die Variable der inneren Schleife mit der Variablen 
		 * der äußeren Schleife belegen.
		 * Für die auszugebenen Zahlen wird die Variable der inneren Schleife benutzt.
		 * 
		 * Ausgabe:
		 * 1
		 * 1 2 
		 * 1 2 3
		 * 1 2 3 4
		 */
		
		// 4 Zeilen
		for ( int i=1; i<5; i++) { 

			// j ist immer i
			for(int j=1; j<=i; j++) { // inner for loop
				System.out.print(j + "\t");
			}
			
			System.out.println();
		}
		
		System.out.println("=============================================");
		
		/**
		 * Inverted sequence pyramid logic program.
		 * 4x äußere Schleife und dann die Variable der inneren Schleife mit der Variablen 
		 * der äußeren Schleife belegen.
		 * Für die auszugebenen Zahlen wird eine eigene Variable benutzt, die jedes Mal um 3 erhöht wird.
		 * 
		 * Ausgabe:
		 * 3
		 * 6 9 
		 * 12 15 18
		 */

		k = 3;
		// 3 Zeilen
		for ( int i=1; i<4; i++) { 

			// j ist immer i
			for(int j=1; j<=i; j++) { // inner for loop
				System.out.print(k + "\t");
				k = k + 3;
			}
			
			System.out.println();
		}
	}
}
