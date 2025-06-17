package oopbasics2.ConstrustorAndKeywords;

public class ThisDemo {

	int a = 2; // global variable
	
	public static void main(String[] args) {

		ThisDemo td = new ThisDemo();
		td.getData();
	}

	public void getData() {
		int a = 3; // local variable
		System.out.println("a in getData: " + a);
		
		// this refers to current object - object scope lies in class level - global variable
		System.out.println("a from class: " + this.a);
		
		// local a + global a
		System.out.println(a + this.a);
	}
}
