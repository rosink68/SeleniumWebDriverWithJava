package msg.group.java_basics;

public class MethodsDemo {

	public static void main(String[] args) {
		
		MethodsDemo d = new MethodsDemo();
		
		String name = d.getData();
		System.out.println(name);
		getData2();
		
		MethodsDemo2 d2 = new MethodsDemo2();
		System.out.println(d2.getUserData());
	}

	public String getData() {
		System.out.println ("hello world");
		return "Max Mustermann";
	}

	public static String getData2() {
		System.out.println ("ich bin static und kann ohne Objekt aufgerufen werden");
		return "Max Mustermann";
	}
}
