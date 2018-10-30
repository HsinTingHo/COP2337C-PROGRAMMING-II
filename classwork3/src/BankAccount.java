import java.util.Scanner;

public class BankAccount {
	String ID;
	String name;
	String address;
	String phoneNumber;
	double balance;
	double rate;
	
	public BankAccount() {
		ID = "0";
		name = "no name";
		address = "no address";
		phoneNumber = "no number";
		balance = 0;
		rate = 0;
	}
	
	public BankAccount(String ID, String name, String address, String phoneNumber, double balance, double rate) {
		this.ID = ID;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
		this.rate = rate;
	}
		
	public BankAccount(String ID, String name,double balance, double rate) {
		this.ID = ID;
		this.name = name;
		this.balance = balance;
		this.rate = rate;
	}
	public BankAccount(String ID, double rate) {
		this.ID = ID;
		this.name = "no name";
		this.address = "no address";
		this.phoneNumber = "no number";
		this.balance = 0;
		this.rate = rate;
	}
	
	public void showAccount() {
		System.out.println("Account ID: "+ID);
		System.out.println("Name: "+ name);
		System.out.println("Address: "+ address);
		System.out.println("Phone Number: "+phoneNumber);
		System.out.println("Balance: "+ balance);
		System.out.println("Rate: "+rate);
	}
}
