package classwork3;

public class Person {
	private String name;
	private String address;
	private String phone;
	
	public Person() {
		name = "Gin";
		address = "123 Hollywood Blvd.";
		phone = "954-123-4123";
	}
	public Person(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public String getName() {
		return this.name;
	}
	public String getAddress() {
		return this.address;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String toString() {
		String output = "Customer: \n";
		output += "Name: " + name + "\n";
		output += "Address: " + address + "\n";
		output += "Phone: " + phone + "\n";
		return output;
	}
}
