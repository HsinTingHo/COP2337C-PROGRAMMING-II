package classwork3;


public class PreferredCustomer extends Customer{
	private int[][] LEV = new int[][] {{500,5}, {1000,6}, {1500,7}, {2000,10}};
	private int discountLev;
	private int spending;
	private double discountAmount;
	
	public PreferredCustomer() {
		spending = 0;
		discountLev = 0;
		discountAmount = 0.0;
	}
	//initiate a new customer
	public PreferredCustomer(String customerNum, boolean inList, int spending) {
		super(customerNum, inList);
		this.spending += spending;
		this.discountLev = findDiscountLev(this.spending);
		this.discountAmount = calcDiscountAmount(this.spending, this.discountLev);
	}
	

	
	private int findDiscountLev(int spending) {
		int dicountLev = 0;
		for(int i = 0; i<4; i++) {
			//if the spending is less than the low bound in the price level, get the lower discount level
			if(spending > LEV[0][0]) {
				if(spending < LEV[i][0]) {
					dicountLev = LEV[i-1][1];
				}
				else { //when the spending is over the highest level, discount level is 10%
					dicountLev = LEV[3][1];
				}
			}
		}
		return dicountLev;
	}
	private static double calcDiscountAmount(int spending, int discountLev) {
		double discountAmount;
		if(spending > 500) {
			discountAmount = spending*(discountLev/100);
		}
		else {
			discountAmount = 0.0;
		}
		return discountAmount;
	}
	
	public int getDiscountLev() {
		return this.discountLev;
	}
	public int getSpending() {
		return this.spending;
	}
	public double getDiscountAmount() {
		return this.discountAmount;
	}
	public void setDiscountLev(int lev) {
		if(lev != 5 && lev != 6 && lev != 7 && lev != 10)
			this.discountLev = 5;
			System.out.println("Invalid discount level. (valid level: 5, 6, 7, 10)");
		this.discountLev = lev;
	}
	public void setSpending(int spending) {
		this.spending = spending;
	}
	public String toString() {
		String output = super.toString();
		output += "Spending: "+ this.spending+ "\n";
		output += "Discount Percentage: "+this.discountLev+"\n";
		output += "Discount Amount: "+this.discountAmount+"\n";
		return output;
	}
}
