package msg.group.java_basics;

public class ExerciseMultidimensionalArraysUsage {

	public static void main(String[] args) {
		
		/**
		 * a[rows][cols]
		 * 	2	4	5
		 * 	3	4	7
		 * 	1	2	6
		 */
		
		int a[][] = new int[2][3];
		a[0][0] = 2;
		a[0][1] = 4;
		a[0][2] = 5;
		a[1][0] = 1;
		a[1][1] = 2;
		a[1][2] = 6;
		System.out.println(a[1][0]);
		
		int b[][] = {{2, 4, 5}, {3, 4, 7}, {1, 2, 6}};
		
		// Iteration über die Zeilen
		for (int x=0; x<b.length; x++) {
			
			// Iteration über die Spalten
			for (int y=0; y<b[x].length; y++) {
				System.out.print(b[x][y] + " ");				
			}
			System.out.println();
		}
	}
}
