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

		int[][] LEV = new int[][] {{500,5}, {1000,6}, {1500,7}, {2000,10}};
		for(int i = 0; i<4; i++) {
			for(int k = 0; k<2; k++)
				System.out.println(LEV[i][k]);
		}
		}
			
}
