package oopbasics2.ConstrustorAndKeywords;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {

		ArrayList<String> a = new ArrayList<String>();
		a.add("Max");
		a.add("java");
		a.add("java");
		System.out.println(a);
		a.add(0, "Hund");
		System.out.println(a);
		/*a.remove(1);
		a.remove("java");
		System.out.println(a);*/
		System.out.println(a.get(2));

		// testing
		System.out.println(a.contains("java"));
		System.out.println(a.indexOf("Max"));
		System.out.println(a.isEmpty());
		System.out.println(a.size());
	}

	public void abc() {
		System.out.println("hello");
	}
}
