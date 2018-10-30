package classwork3;

public class testClasswork3 {
	public static void main(String[] args) {
		Person p1 = new Person();
		System.out.println(p1.toString());

		Customer c1 = new Customer("Ireen", "456 Sunset Blvd.", "954-639-0854", "147-B", false);
		System.out.println(c1.toString());
		c1.setName("Jake");
		c1.setPhone("999-888-7777");
		System.out.println(c1.toString());

		
	}
}
