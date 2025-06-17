package oopbasics1.Inheritance;

// function overloading
// either argument count should be different or 
// argument data type should be different
public class ChildLevel extends ChildDemo {

	public static void main(String[] args) {
		
		ChildLevel cl = new ChildLevel();
		cl.getData(2);
		cl.getData("hello");
		cl.getData(2, 10);
	}
	
	public void getData(int a) {
		System.out.println(a);
	}
	
	public void getData(String a) {
		System.out.println(a);
	}
	
	public void getData(int a, int b) {
		System.out.println(b);
	}
}
