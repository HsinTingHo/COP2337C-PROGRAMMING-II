package finalProject;

import java.util.Random;

public class Customer {
	private String name;
	private String address;
	private String phone;
	private static String accountNum;
	
	public Customer(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.accountNum = genAccNum();
		
	}
	private String genAccNum() {
		String acc = "A";
		Random rand = new Random();
		int num = rand.nextInt(9999);
		acc += num;
		return acc;
	}
	public String getName() {
		return this.name;
	}
	public String getAdd() {
		return this.address;
	}
	public String getPhone() {
		return this.phone;
	}

	public String getAccNum() {
		return this.accountNum;
	}
}
