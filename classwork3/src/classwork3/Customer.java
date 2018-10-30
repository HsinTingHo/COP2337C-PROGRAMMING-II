package classwork3;

public class Customer extends Person{
	private String customerNum;
	private boolean inList;
	//machenism for accumulating customer number
	public Customer() {
		customerNum = "000-A";
		inList = true;
	}
	public Customer(String name, String address, String phone, String customerNum, boolean inList) {
		super(name, address, phone);
		if(validCustomerNum(customerNum)) {
			this.customerNum = customerNum;
		}
		else {
			this.customerNum = "000-A";
			System.out.println("Invalid customer number.");
		}
		this.inList = inList;
	}
	public String getCustomerNum() {
		return this.customerNum;
	}
	public boolean getInList() {
		return this.inList;
	}
	public void setCustomerNum(String customerNum) {
		if(validCustomerNum(customerNum)) {
			this.customerNum = customerNum;
		}
		else {
			this.customerNum = "000-A";
			System.out.println("Invalid customer number");
		}
		
	}
	public void setInList(boolean inList) {
		this.inList = inList;
	}
	private boolean validCustomerNum(String customerNum) {
		
		if(customerNum.length() != 5) {
			return false;
		}		
		else {
			for(int i = 0; i < 3; i++) {
				if(!Character.isDigit(customerNum.charAt(i))) {
					return false;
				}
			}
			if(customerNum.charAt(3) != '-') {
				return false;
			}
			if(customerNum.charAt(4) < 'A' || customerNum.charAt(4) >'Y') {
				return false;
			}
			
		}
		return true;
	}
	public String toString() {
		String output = super.toString();
		output += "Customer Number: " + customerNum + "\n";
		output += "In Email List: " + inList + "\n";
		return output;
	}
}
