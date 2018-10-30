
public class TestBankAccount {
	
	public static void main(String[] args) {
		BankAccount b1 = new BankAccount();
		System.out.println("Bank account b1:");
		b1.showAccount();
		
		BankAccount b2 = new BankAccount("0001", 1.0);
		System.out.println("Bank account b2:");
		b2.showAccount();
	}
}
