package msg.group.java_basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayVsArrayList {

	public static void main(String[] args) {
		
		// Arrays sind starr, d.h. die Größe wird bei der Anlage festgelegt
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 4;
		int[] arr2 = {1, 4, 7, 19, 34, 129, 892}; 
		for (int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		System.out.println("--------------------------");
		
		// ArrayList ist dynamisch
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("Eva");
		aList.add("Max");
		aList.add("Sarah");
		aList.add("test");
		aList.add("Selenium");
		
		aList.remove(3);
		System.out.println(aList.get(3));
		
		for (int i=0; i<aList.size(); i++) {
			System.out.println(aList.get(i));
		}
		
		System.out.println("-------");
		
		for (String val : aList) {
			System.out.println(val);
		}
		
		// item is present in Arraylist
		System.out.println(aList.contains("Selenium"));
		
		System.out.println("-------");
		
		// Array in ArrayList konvertieren
		String[] names = {"Max", "Hans", "Emilie", "Anna"};
		List<String> namesList = Arrays.asList(names);
		System.out.println(namesList);
		System.out.println(namesList.contains("Anna"));
	}
}
