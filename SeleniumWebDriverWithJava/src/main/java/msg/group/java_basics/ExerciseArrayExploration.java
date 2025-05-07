package msg.group.java_basics;

public class ExerciseArrayExploration {

	public static void main(String[] args) {
		
		int numbers[] = {1, 3, 6, 22, 99};
		
		// first element of the array
		System.out.println(numbers[0]);
		
		// last element of the array
		System.out.println(numbers[numbers.length-1]);
		
		System.out.println("-------------------");

		// print elements in reverse order
		for (int i = numbers.length-1; i >= 0 ; i--) {
			if (i == -1) {
				break;
			}
			System.out.println(numbers[i]);
		}
		
		System.out.println("-------------------");
		
		// calculate the total number of elements
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum = sum + numbers[i];
		}
		System.out.println(sum);
	}

}
