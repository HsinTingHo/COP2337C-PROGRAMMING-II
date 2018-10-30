package classwork3;
import java.util.Map;

public class PreferredCustomer extends Customer{
	private  int[][] LEV = new int[][] {{500,5}, {1000,6}, {1500,7}, {2000,10}};
	private int[] discountLev;
	private int spending;
	
	public PreferredCustomer() {
		this.spending = spending;
		this.discountLev = LEV[0];
	}
	public PreferredCustomer(int spending) {
		
	}
}
